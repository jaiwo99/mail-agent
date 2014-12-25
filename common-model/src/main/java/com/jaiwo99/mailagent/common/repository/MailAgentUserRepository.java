package com.jaiwo99.mailagent.common.repository;

import com.jaiwo99.mailagent.common.model.MailAgentUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author jaiwo99
 */
public interface MailAgentUserRepository extends MongoRepository<MailAgentUser, String> {

    Optional<MailAgentUser> findByUsername(final String username);
}
