package com.jaiwo99.mailagent.userwebapp.service;

import com.jaiwo99.mailagent.common.dto.UserDTO;
import com.jaiwo99.mailagent.common.model.MailAgentUser;
import com.jaiwo99.mailagent.common.repository.MailAgentUserRepository;
import com.jaiwo99.mailagent.common.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author jaiwo99
 */
@Service
public class UserServiceImpl implements UserService {

    @Inject
    MailAgentUserRepository mailAgentUserRepository;

    @Override
    public void register(UserDTO userDTO) {
        final MailAgentUser mailAgentUser = new MailAgentUser();
        mailAgentUser.setUsername(userDTO.getUsername());
        mailAgentUser.setPassword(userDTO.getPassword());
        mailAgentUser.setAuthorities(userDTO.getRoles());
        mailAgentUserRepository.save(mailAgentUser);
    }
}
