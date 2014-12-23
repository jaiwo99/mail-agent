package com.jaiwo99.mailagent.anonymization;

import com.jaiwo99.mailagent.common.dto.MailDTO;
import com.jaiwo99.mailagent.common.model.Conversation;
import com.jaiwo99.mailagent.common.model.MailContent;
import com.jaiwo99.mailagent.common.repository.ConversationRepository;
import com.jaiwo99.mailagent.common.repository.MailContentRepository;

import javax.inject.Inject;

/**
 * @author jaiwo99
 */
public class AnonymizationAgent {

    @Inject
    ConversationRepository conversationRepository;
    @Inject
    MailContentRepository mailContentRepository;

    @SuppressWarnings("unused")
    public void handleMessage(final MailDTO mailDTO) {
        mailContentRepository.save(new MailContent(getOrCreateConversation(mailDTO.getFrom(), mailDTO.getTo(), mailDTO.getConversationReference()), mailDTO.anonymize()));
    }

    Conversation getOrCreateConversation(String from, String to, String conversationReference) {
        final Conversation conversation = conversationRepository.findByFromAndToAndConversationReference(from, to, conversationReference);
        if(conversation == null) {
            return conversationRepository.save(new Conversation(conversationReference, from, to));
        }
        return conversation;
    }
}
