package com.jaiwo99.mailagent.userwebapp.service;

import com.jaiwo99.mailagent.common.dto.UserDTO;
import com.jaiwo99.mailagent.userwebapp.command.RegisterCmd;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author jaiwo99
 */
@Service
public class UserDTOResolver {

    @Inject
    PasswordEncoder passwordEncoder;

    public UserDTO resolve(final RegisterCmd registerCmd) {
        final UserDTO userDTO = new UserDTO();
        userDTO.setUsername(registerCmd.getUsername());
        userDTO.setPassword(passwordEncoder.encode(registerCmd.getPassword()));
        userDTO.setRoles(registerCmd.getRoles());
        return userDTO;
    }
}
