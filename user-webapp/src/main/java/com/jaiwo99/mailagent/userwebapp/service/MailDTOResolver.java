package com.jaiwo99.mailagent.userwebapp.service;

import com.jaiwo99.mailagent.common.dto.MailDTO;
import com.jaiwo99.mailagent.userwebapp.command.MessageCmd;

/**
 * @author jaiwo99
 */
public interface MailDTOResolver {

    /**
     * Resolve {@link com.jaiwo99.mailagent.userwebapp.command.MessageCmd} to {@link com.jaiwo99.mailagent.common.dto.MailDTO}
     * by using different strategies:
     *
     * e.g.: you can find the 'from', 'to', 'conversation' information by hitting DB with given 'receiverAlias'
     */
    public MailDTO resolve(MessageCmd messageCmd);
}
