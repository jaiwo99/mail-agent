package com.jaiwo99.mailagent.common.service;

import com.jaiwo99.mailagent.common.dto.MailDTO;

/**
 * @author jaiwo99
 */
public interface MessageSendService {

    void send(MailDTO mailDTO);
}
