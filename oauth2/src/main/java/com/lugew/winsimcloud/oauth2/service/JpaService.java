package com.lugew.winsimcloud.oauth2.service;

import com.lugew.winsimcloud.jpa.service.BasicService;
import com.lugew.winsmcloud.core.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * JPA业务逻辑
 *
 * @author 夏露桂
 * @since 2021/1/16 16:20
 */
public class JpaService<T extends Entity<ID>, R extends JpaRepository<T, ID> & QuerydslPredicateExecutor<T>, ID> extends BasicService<T, R, ID> {
    @Override
    public Long getUserId() {
        return 1L;
    }
}
