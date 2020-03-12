package xyz.blackmonster.resume.repository.model.builder;

import xyz.blackmonster.resume.repository.model.AddressDAO;
import xyz.blackmonster.resume.repository.model.EducationDAO;
import xyz.blackmonster.resume.repository.model.UserProfileDAO;

import java.time.LocalDate;
import java.util.UUID;

public class EducationDAOBuilder {

    private UUID uuid;

    private String title;

    private String description;

    private String institution;

    private LocalDate start;

    private LocalDate end;

    private boolean certification;

    private AddressDAO address;

    private UserProfileDAO userProfile;

    private EducationDAOBuilder() {

    }

    public static EducationDAOBuilder instance() {
        return new EducationDAOBuilder();
    }

    public EducationDAOBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public EducationDAOBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public EducationDAOBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public EducationDAOBuilder setInstitution(String institution) {
        this.institution = institution;
        return this;
    }

    public EducationDAOBuilder setStart(LocalDate start) {
        this.start = start;
        return this;
    }

    public EducationDAOBuilder setEnd(LocalDate end) {
        this.end = end;
        return this;
    }

    public EducationDAOBuilder setCertification(boolean certification) {
        this.certification = certification;
        return this;
    }

    public EducationDAOBuilder setAddress(AddressDAO address) {
        this.address = address;
        return this;
    }

    public EducationDAOBuilder setUserProfile(UserProfileDAO userProfile) {
        this.userProfile = userProfile;
        return this;
    }

    public EducationDAO build() {
        return new EducationDAO(uuid, title, description, institution, start, end, certification, address, userProfile);
    }
}
