package xyz.blackmonster.resume.service.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

public class UserBean implements UserDetails {

    private String uuid;

    private String username;

    private String password;

    private String userProfileUuid;

    public UserBean() {
    }

    public UserBean(
            String uuid, String username, String password, String userProfileUuid) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.userProfileUuid = userProfileUuid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserProfile() {
        return userProfileUuid;
    }

    public void setUserProfile(String userProfileUuid) {
        this.userProfileUuid = userProfileUuid;
    }
}
