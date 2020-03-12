package xyz.blackmonster.resume.repository.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="skills")
public class SkillDAO {

    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private Integer scale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expertiseUuid")
    private ExpertiseDAO expertise;

    public SkillDAO() {
    }

    public SkillDAO(UUID uuid, String type, Integer rating, Integer scale) {
        this.uuid = uuid;
        this.type = type;
        this.rating = rating;
        this.scale = scale;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public ExpertiseDAO getExpertise() {
        return expertise;
    }

    public void setExpertise(ExpertiseDAO expertise) {
        this.expertise = expertise;
    }
}
