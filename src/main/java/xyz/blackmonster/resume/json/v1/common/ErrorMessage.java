package xyz.blackmonster.resume.json.v1.common;

public class ErrorMessage {

    String description;

    public ErrorMessage() {
    }

    public ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
