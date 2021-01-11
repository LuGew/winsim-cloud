package com.lugew.winsimcloud.oauth2.service;

import com.lugew.winsimcloud.oauth2.entity.User;
import com.lugew.winsimcloud.oauth2.repository.UserRepository;
import com.lugew.winsmcloud.core.exception.Exception;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 夏露桂
 * @date 2020/12/31 17:44
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("username:{}", username);
        User user = userRepository.findByName(username)
                .orElseThrow(() -> new Exception("user.not.found"));
        return generateUserDetails(user);
    }

    public UserDetails generateUserDetails(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .build();
    }

}
