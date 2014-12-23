package com.jaiwo99.mailagent.common.repository;

import com.jaiwo99.mailagent.common.model.MailContent;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jaiwo99
 */
public interface MailContentRepository extends MongoRepository<MailContent, String> {
}
