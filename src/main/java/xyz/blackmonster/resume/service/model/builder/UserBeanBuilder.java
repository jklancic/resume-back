package xyz.blackmonster.resume.service.model.builder;

import xyz.blackmonster.resume.service.model.*;

public class UserBeanBuilder {

    private String uuid;
    private String username;
    private String password;
    private String userProfileUuid;

    private UserBeanBuilder() {

    }

    public static UserBeanBuilder instance() {
        return new UserBeanBuilder();
    }

    public UserBeanBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public UserBeanBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBeanBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBeanBuilder setUserProfile(String userProfileUuid) {
        this.userProfileUuid = userProfileUuid;
        return this;
    }

    public UserBean build() {
        return new UserBean(uuid, username, password, userProfileUuid);
    }
}
