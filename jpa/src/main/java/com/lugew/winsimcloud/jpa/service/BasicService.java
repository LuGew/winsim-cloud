package com.lugew.winsimcloud.jpa.service;

import com.lugew.winsmcloud.core.entity.Entity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author 夏露桂
 * @since 2021/1/15 17:24
 */
public abstract class BasicService<T extends Entity<ID>, R extends JpaRepository<T, ID> & QuerydslPredicateExecutor<T>, ID> extends AbstractService<T, R, ID> {

}
