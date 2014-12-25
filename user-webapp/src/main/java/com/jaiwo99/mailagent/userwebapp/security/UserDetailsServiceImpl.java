package com.jaiwo99.mailagent.userwebapp.security;

import com.jaiwo99.mailagent.common.model.MailAgentUser;
import com.jaiwo99.mailagent.common.repository.MailAgentUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author jaiwo99
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Inject
    MailAgentUserRepository mailAgentUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MailAgentUser> mailAgentUser = mailAgentUserRepository.findByUsername(username);
        return resolveUser(mailAgentUser.orElseThrow(() -> new UsernameNotFoundException(String.format("user[username:%s] cannot be found", username))));
    }

    private UserDetails resolveUser(MailAgentUser mailAgentUser) {
        return new User(
                mailAgentUser.getUsername(),
                mailAgentUser.getPassword(),
                mailAgentUser.getAuthorities().stream().map(
                        role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
    }
}
