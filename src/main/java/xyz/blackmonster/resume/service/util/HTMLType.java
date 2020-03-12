package xyz.blackmonster.resume.service.util;

public enum HTMLType {
    HEADER_PROFESSION("<h2 class=\"primary\">%s</h2>"),
    HEADER_FULL_NAME("<h1>%s %s</h1>"),
    HEADER_PROFILE("<div class=\"web-profile\"></div>"),
    HEADER_PROFILE_INFO("<span class=\"info\">%s</span>"),
    HEADER_PROFILE_GITHUB_ICON("<i class=\"fab fa-github\"></i>"),
    HEADER_PROFILE_LINKEDIN_ICON("<i class=\"fab fa-linkedin\"></i>"),
    SECTION_CONTENT("<div class=\"section-content\"></div>"),
    SECTION_TITLE("<p class=\"section-title\">%s</p>"),
    SECTION_SUBTITLE("<p class=\"section-subtitle\">%s (%s, %s)</p>"),
    SECTION_JOB_TITLE("<p class=\"section-title small-bottom-margin\">%s, %s - %s</p>"),
    SECTION_JOB_SUBTITLE("<p class=\"section-subtitle small-top-margin\">%s (%s, %s)</p>"),
    SECTION_JOB_LIST("<ul class=\"list small-top-margin\"></ul>"),
    SECTION_JOB_LIST_ITEM("<li>%s</li>"),
    SECTION_SKILL_SUBTITLE("<p class=\"section-subtitle\">%s</p>");

    HTMLType(String html) {
        this.htmlFormatting = html;
    }

    private String htmlFormatting;

    public String getHtmlFormatting() {
        return htmlFormatting;
    }
}
