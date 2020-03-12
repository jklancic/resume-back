package xyz.blackmonster.resume.json.v1.common;

public class Education {

    private String uuid;

    private String title;

    private String description;

    private String institution;

    private String start;

    private String end;

    private Address address;

    private boolean certification;

    public Education() {
    }

    public Education(String uuid, String title, String description, String institution, String start, String end, Address address, boolean certification) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.institution = institution;
        this.start = start;
        this.end = end;
        this.address = address;
        this.certification = certification;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }
}
