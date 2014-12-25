package com.jaiwo99.mailagent.userwebapp.command;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author jaiwo99
 */
public class LoginCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Email
    String username;
    @NotBlank
    String password;

    public LoginCmd() {
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
}
