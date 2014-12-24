package com.jaiwo99.mailagent.userwebapp.command;

import com.jaiwo99.mailagent.common.dto.MailDTO;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author jaiwo99
 */
public class MessageCmd implements Serializable {
    private static final long serialVersionUID =1L;

    @NotBlank
    String receiverAlias;
    @NotBlank
    String subject;
    @NotBlank
    String content;

    public String getReceiverAlias() {
        return receiverAlias;
    }

    public void setReceiverAlias(String receiverAlias) {
        this.receiverAlias = receiverAlias;
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

    public MailDTO toMailDTO() {
        return new MailDTO();
    }
}
