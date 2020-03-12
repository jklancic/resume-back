package xyz.blackmonster.resume.repository.model.builder;

import xyz.blackmonster.resume.repository.model.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class UserDAOBuilder {

    private UUID uuid;
    private String username;
    private String password;
    private UserProfileDAO profile;

    private UserDAOBuilder() {

    }

    public static UserDAOBuilder instance() {
        return new UserDAOBuilder();
    }

    public UserDAOBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public UserDAOBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserDAOBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDAOBuilder setProfile(UserProfileDAO profile) {
        this.profile = profile;
        return this;
    }

    public UserDAO build() {
        return new UserDAO(uuid, username, password, profile);
    }
}
