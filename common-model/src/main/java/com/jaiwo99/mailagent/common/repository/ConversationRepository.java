package com.jaiwo99.mailagent.common.repository;

import com.jaiwo99.mailagent.common.model.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jaiwo99
 */
public interface ConversationRepository extends MongoRepository<Conversation, String> {

    Conversation findByFromAndToAndConversationReference(String from, String to, String conversationReference);

}
