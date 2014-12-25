package com.jaiwo99.mailagent.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jaiwo99
 */
@Document(collection = "mail_agent_user")
public class MailAgentUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    String id;
    @Indexed(unique = true)
    String username;
    @JsonIgnore
    String password;
    Set<String> authorities = new HashSet<>();

    public MailAgentUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
