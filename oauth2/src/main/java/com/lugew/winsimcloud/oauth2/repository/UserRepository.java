package com.lugew.winsimcloud.oauth2.repository;

import com.lugew.winsimcloud.oauth2.entity.User;
import com.lugew.winsmcloud.core.repository.Repository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @author 夏露桂
 * @since 2021/1/11 17:32
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long>, Repository<User>, QuerydslPredicateExecutor<User> {

    Optional<User> findByName(String name);
}
