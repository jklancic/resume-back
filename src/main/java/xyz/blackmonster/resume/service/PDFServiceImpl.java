package xyz.blackmonster.resume.service;

import com.google.cloud.storage.*;
import com.itextpdf.html2pdf.HtmlConverter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import xyz.blackmonster.resume.service.contract.PDFService;
import xyz.blackmonster.resume.service.contract.UserService;
import xyz.blackmonster.resume.service.model.JobBean;
import xyz.blackmonster.resume.service.model.SkillBean;
import xyz.blackmonster.resume.service.model.UserProfileBean;
import xyz.blackmonster.resume.service.util.HTMLType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PDFServiceImpl implements PDFService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PDFServiceImpl.class);

    private static String RESUME_FILE_PATH = "resume_%s_%s";

    private final String bucketName;

    private final UserService userService;

    @Autowired
    public PDFServiceImpl(@Value("${pdf.bucket-name}") String bucketName, UserService userService) {
        this.bucketName = bucketName;
        this.userService = userService;
    }

    @Override
    public void publishResume() {
        UserProfileBean userProfileBean = userService.getUserProfile();
        if (userProfileBean == null) {
            LOGGER.error("User profile is missing.");
            throw new IllegalStateException("User profile is missing. PDF can not be generated.");
        }

        String pdfLink = createPDF(userProfileBean);
        userService.updatePdfLink(userProfileBean.getUuid(), pdfLink);
    }

    private String createPDF(UserProfileBean userProfileBean) {
        try {
            String resumeFilePath = String.format(RESUME_FILE_PATH, userProfileBean.getFirstname(), userProfileBean.getLastname());
            Document resumeAsHtml = createHtmlDocument(userProfileBean);
            HtmlConverter.convertToPdf(resumeAsHtml.html(), new FileOutputStream(resumeFilePath));
            File newResume = new File(resumeFilePath);

            return uploadFileToCloud(resumeFilePath, newResume.getName());
        } catch (IOException e) {
            LOGGER.error("Failed to create new resume file.", e);
            throw new IllegalStateException("PDF can not be generated.");
        }
    }

    private String uploadFileToCloud(String filePath, String fileName) throws IOException {
        LOGGER.debug("Converting file to bytes.");
        byte[] fileAsBytes = Files.readAllBytes(Paths.get(filePath));

        LOGGER.debug("Initializing cloud service.");
        Storage storage = StorageOptions.getDefaultInstance().getService();

        LOGGER.debug("Replacing PDF file.");
        BlobId blobId = BlobId.of(bucketName, fileName);
        storage.delete(blobId);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/pdf").build();
        Blob blob = storage.create(blobInfo, fileAsBytes);

        LOGGER.debug("Adding public read access.");
        Acl.Builder builder = Acl.newBuilder(Acl.User.ofAllUsers(), Acl.Role.READER);
        blob.createAcl(builder.build());

        return blob.getMediaLink();
    }

    private Document createHtmlDocument(UserProfileBean userProfileBean) throws IOException {
        File file = new ClassPathResource("templates/resume-template.html").getFile();
        Document document = Jsoup.parse(file, "UTF-8");
        Element basicInfo = document
                .select("#basic-info")
                .get(0);

        generateHeader(userProfileBean, basicInfo);

        createBody(userProfileBean, document);

        return document;
    }

    private void createBody(UserProfileBean userProfileBean, Document document) {
        createEducationSection(userProfileBean, document);

        createJobSection(userProfileBean, document);

        createSkillSection(userProfileBean, document);
    }

    private void createSkillSection(UserProfileBean userProfileBean, Document document) {
        Element skillParagraph = document
                .select("#skill-section")
                .get(0);
        skillParagraph.after(createHtmlContent(HTMLType.SECTION_CONTENT));
        Element skillContent = skillParagraph.nextElementSibling();

        userProfileBean.getExpertise().forEach(expertiseItem ->
                skillContent
                        .append(createHtmlContent(HTMLType.SECTION_TITLE, expertiseItem.getCategory()))
                        .append(createHtmlContent(HTMLType.SECTION_SKILL_SUBTITLE, expertiseItem.getProficient().stream().map(SkillBean::getType).collect(Collectors.joining(", ")))));
    }

    private void createJobSection(UserProfileBean userProfileBean, Document document) {
        Element jobParagraph = document
                .select("#job-section")
                .get(0);

        List<JobBean> jobs = userProfileBean.getJobs();
        Collections.reverse(jobs);

        jobs.stream().forEach(jobItem -> {
            Element previousSibling = jobParagraph.after(createHtmlContent(HTMLType.SECTION_CONTENT));
            Element content = previousSibling.nextElementSibling();

            content
                    .append(createHtmlContent(
                            HTMLType.SECTION_JOB_TITLE, jobItem.getTitle(),
                            formatDate(jobItem.getStart()), formatDate(jobItem.getEnd())))
                    .append(createHtmlContent(HTMLType.SECTION_JOB_SUBTITLE,
                            jobItem.getCompany().getName(),
                            jobItem.getCompany().getAddress().getCity(),
                            jobItem.getCompany().getAddress().getCountry()))
                    .append(createHtmlContent(HTMLType.SECTION_JOB_LIST));

            Element jobDescriptionSection = content.children().last();
            jobItem.getDuties().forEach(jobDescription ->
                    jobDescriptionSection.append(createHtmlContent(HTMLType.SECTION_JOB_LIST_ITEM, jobDescription.getDescription())));
        });
    }

    private void createEducationSection(UserProfileBean userProfileBean, Document document) {
        Element educationParagraph = document
                .select("#education-section")
                .get(0);
        educationParagraph.after(createHtmlContent(HTMLType.SECTION_CONTENT));
        Element educationContent = educationParagraph.nextElementSibling();

        userProfileBean.getEducation().forEach(educationItem ->
                educationContent
                        .append(createHtmlContent(HTMLType.SECTION_TITLE, educationItem.getTitle()))
                        .append(createHtmlContent(HTMLType.SECTION_SUBTITLE,
                                educationItem.getInstitution(),
                                educationItem.getAddress().getCity(),
                                educationItem.getAddress().getCountry())));
    }

    private void generateHeader(UserProfileBean userProfileBean, Element basicInfo) {
        basicInfo.append(createHtmlContent(HTMLType.HEADER_PROFESSION, userProfileBean.getProfession()));
        basicInfo.append(createHtmlContent(HTMLType.HEADER_FULL_NAME, userProfileBean.getFirstname(), userProfileBean.getLastname()));

        StringBuilder contactProfile = new StringBuilder();
        contactProfile.append(createHtmlContent(HTMLType.HEADER_PROFILE_INFO, userProfileBean.getUserContact().getPhone()));
        contactProfile.append(createHtmlContent(HTMLType.HEADER_PROFILE_INFO, userProfileBean.getUserContact().getEmail()));
        contactProfile.append(createHtmlContent(HTMLType.HEADER_PROFILE_INFO, userProfileBean.getUserContact().getWeb()));

        basicInfo.append(createHtmlContent(HTMLType.HEADER_PROFILE));
        basicInfo.children().last().append(contactProfile.toString());

        StringBuilder webProfile = new StringBuilder();
        webProfile.append(createHtmlContent(HTMLType.HEADER_PROFILE));
        webProfile.append(createHtmlContent(HTMLType.HEADER_PROFILE_GITHUB_ICON));
        webProfile.append(createHtmlContent(HTMLType.HEADER_PROFILE_INFO, userProfileBean.getUserContact().getGithub()));
        webProfile.append(createHtmlContent(HTMLType.HEADER_PROFILE_LINKEDIN_ICON));
        webProfile.append(createHtmlContent(HTMLType.HEADER_PROFILE_INFO, userProfileBean.getUserContact().getLinkedin()));

        basicInfo.append(createHtmlContent(HTMLType.HEADER_PROFILE));
        basicInfo.children().last().append(webProfile.toString());
    }

    private String createHtmlContent(HTMLType type) {
        return type.getHtmlFormatting();
    }

    private String createHtmlContent(HTMLType type, String... content) {
        return String.format(type.getHtmlFormatting(), content);
    }

    private String formatDate(LocalDate date) {
        if (date == null) {
            return "current";
        }

        return date.format(DateTimeFormatter.ofPattern("MM/yyyy"));
    }
}
