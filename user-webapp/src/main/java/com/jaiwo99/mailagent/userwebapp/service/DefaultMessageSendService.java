package com.jaiwo99.mailagent.userwebapp.service;

import com.jaiwo99.mailagent.common.dto.MailDTO;
import com.jaiwo99.mailagent.common.service.MessageSendService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author jaiwo99
 */
@Service
public class DefaultMessageSendService implements MessageSendService {

    @Inject
    RabbitTemplate rabbitTemplate;

    @Override
    public void send(MailDTO mailDTO) {
        rabbitTemplate.convertAndSend(mailDTO);
    }
}
