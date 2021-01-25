package com.lugew.winsincloud.oauth2.repository;

import com.lugew.winsincloud.oauth2.entity.User;
import com.lugew.winsin.mybatis.mapper.BasicMapper;

import java.util.Optional;

/**
 * @author 夏露桂
 * @since 2021/1/11 17:32
 */
public interface UserRepository extends BasicMapper<User> {
    Optional<User> findByName(String name);
}
