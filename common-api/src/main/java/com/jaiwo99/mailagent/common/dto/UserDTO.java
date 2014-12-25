package com.jaiwo99.mailagent.common.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jaiwo99
 */
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    String username;
    String password;
    Set<String> roles = new HashSet<>();

    public UserDTO() {
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
