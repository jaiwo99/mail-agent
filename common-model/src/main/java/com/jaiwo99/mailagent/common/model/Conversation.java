package com.jaiwo99.mailagent.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author jaiwo99
 */
@Document
@CompoundIndex(name="from_to_conversationRef_idx", def = "{'from' : 1, 'to' : 1, 'conversationReference' : 1}")
public class Conversation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    String id;
    String conversationReference;
    String from;
    String to;


    public Conversation() {
    }

    public Conversation(String conversationReference, String from, String to) {
        this.conversationReference = conversationReference;
        this.from = from;
        this.to = to;
    }

    public String getId() {
        return id;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getConversationReference() {
        return conversationReference;
    }

    public void setConversationReference(String conversationReference) {
        this.conversationReference = conversationReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conversation that = (Conversation) o;

        if (conversationReference != null ? !conversationReference.equals(that.conversationReference) : that.conversationReference != null)
            return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (conversationReference != null ? conversationReference.hashCode() : 0);
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }
}
