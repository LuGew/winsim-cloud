package com.lugew.winsimcloud.oauth2.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 授权服务器配置
 *
 * @author 夏露桂
 * @date 2020/12/31 16:48
 */
@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final RedisConnectionFactory redisConnectionFactory;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenStore(new RedisTokenStore(redisConnectionFactory));
    }

}
