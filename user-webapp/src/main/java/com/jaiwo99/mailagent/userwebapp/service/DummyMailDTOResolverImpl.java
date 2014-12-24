package com.jaiwo99.mailagent.userwebapp.service;

import com.jaiwo99.mailagent.common.dto.MailDTO;
import com.jaiwo99.mailagent.userwebapp.command.MessageCmd;
import org.springframework.stereotype.Service;

/**
 * @author jaiwo99
 */
@Service
public class DummyMailDTOResolverImpl implements MailDTOResolver {

    @Override
    public MailDTO resolve(MessageCmd messageCmd) {
        final MailDTO mailDTO = new MailDTO();
        mailDTO.setFrom("dummy-from@jaiwo99.com");
        mailDTO.setTo("dummy-to@jaiwo99.com");
        mailDTO.setSubject(messageCmd.getSubject());
        mailDTO.setContent(messageCmd.getContent());
        mailDTO.setConversationReference("dummy-conversation-reference");
        return mailDTO;
    }
}
