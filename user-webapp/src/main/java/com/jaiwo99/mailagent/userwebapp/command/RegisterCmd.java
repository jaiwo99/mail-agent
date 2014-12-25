package com.jaiwo99.mailagent.userwebapp.command;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jaiwo99
 */
public class RegisterCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Email
    String username;
    @NotBlank
    String password;
    Set<String> roles = new HashSet<>();

    public RegisterCmd() {
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
