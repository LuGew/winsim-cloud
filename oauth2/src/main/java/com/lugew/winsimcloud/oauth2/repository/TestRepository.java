package com.lugew.winsimcloud.oauth2.repository;

import com.lugew.winsimcloud.oauth2.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author 夏露桂
 * @since 2021/1/14 10:12
 */
public interface TestRepository extends JpaRepository<Test, Long>, QuerydslPredicateExecutor<Test> {
}
