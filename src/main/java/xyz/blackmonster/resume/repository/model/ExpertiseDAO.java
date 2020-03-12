package xyz.blackmonster.resume.repository.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="expertise")
public class ExpertiseDAO {
	
	@Id
    @GeneratedValue
    private UUID uuid;

	@Column(nullable = false)
    private String category;

    @OneToMany(mappedBy = "expertise", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SkillDAO> proficient;

    @Column(nullable = false)
	private Boolean favorite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userProfileUuid")
    private UserProfileDAO userProfile;

    public ExpertiseDAO() {
    }

    public ExpertiseDAO(UUID uuid, String category, Set<SkillDAO> proficient, boolean favorite, UserProfileDAO userProfile) {
        this.uuid = uuid;
        this.category = category;
        this.proficient = proficient;
        this.favorite = favorite;
        this.userProfile = userProfile;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<SkillDAO> getProficient() {
        return proficient;
    }

    public void setProficient(Set<SkillDAO> proficient) {
        this.proficient = proficient;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public UserProfileDAO getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDAO userProfile) {
        this.userProfile = userProfile;
    }
}