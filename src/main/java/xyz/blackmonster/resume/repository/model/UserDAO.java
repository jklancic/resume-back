package xyz.blackmonster.resume.repository.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="users")
public class UserDAO {
	
	@Id
    @GeneratedValue
    private UUID uuid;

	@Column(nullable = false, unique=true)
    private String username;

	@Column(nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileUuid")
    private UserProfileDAO profile;

    public UserDAO() {
    }

    public UserDAO(UUID uuid, String username, String password, UserProfileDAO profile) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfileDAO getProfile() {
        return profile;
    }

    public void setProfile(UserProfileDAO profile) {
        this.profile = profile;
    }
}