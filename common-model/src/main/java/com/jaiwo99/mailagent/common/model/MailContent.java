package com.jaiwo99.mailagent.common.model;

import com.jaiwo99.mailagent.common.dto.MailDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author jaiwo99
 */
@Document(collection = "mail_content")
public class MailContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    String id;
    String from;
    String to;
    String subject;
    String content;
    @DBRef(lazy = true)
    Conversation conversation;

    public MailContent() {
    }

    public MailContent(Conversation conversation, MailDTO mailDTO) {
        this.conversation = conversation;
        this.from = mailDTO.getFrom();
        this.to = mailDTO.getTo();
        this.subject = mailDTO.getSubject();
        this.content = mailDTO.getContent();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
