package com.jaiwo99.mailagent.common.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.function.Function;

/**
 * @author jaiwo99
 */
public class MailDTO implements Serializable {

    private static final long serialVersionUID = 2L;

    @Email
    String from;
    @Email
    String to;
    @NotBlank
    String subject;
    @NotBlank
    String content;
    @NotBlank
    String conversationReference;

    public transient final Function<MailDTO, MailDTO> DEFAULT_ANONYMIZE_FUNC = input -> {
        final MailDTO mailDTO = new MailDTO();
        mailDTO.setSubject(input.subject);
        mailDTO.setContent(input.content);
        mailDTO.setConversationReference(input.conversationReference);
        mailDTO.setFrom("anonymous-" + from.hashCode());
        mailDTO.setTo("anonymous-" + to.hashCode());
        return mailDTO;
    };

    public MailDTO anonymize() {
        return anonymize(DEFAULT_ANONYMIZE_FUNC);
    }

    public MailDTO anonymize(Function<MailDTO, MailDTO> function) {
        return function.apply(this);
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

    public String getConversationReference() {
        return conversationReference;
    }

    public void setConversationReference(String conversationReference) {
        this.conversationReference = conversationReference;
    }
}
