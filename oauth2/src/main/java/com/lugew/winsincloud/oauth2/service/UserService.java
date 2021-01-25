package com.lugew.winsincloud.oauth2.service;

import com.lugew.winsincloud.oauth2.entity.User;
import com.lugew.winsincloud.oauth2.repository.UserRepository;
import com.lugew.winsin.core.exception.Exception;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author 夏露桂
 * @date 2020/12/31 17:44
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService extends BasicService<UserRepository, User, Long> implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username:{}", username);
        User user = getDao().findByName(username)
                .orElseThrow(() -> new Exception("user.not.found"));
        return generateUserDetails(user);
    }

    public UserDetails generateUserDetails(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getName())
                .password(passwordEncoder.encode(user.getPassword()))
                .authorities(new SimpleGrantedAuthority("ROLE_ADMIN"))
                .build();
    }

}
