package com.lugew.winsimcloud.oauth2.service;

import com.lugew.winsmcloud.core.entity.Entity;
import com.lugew.winsmcloud.core.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;

/**
 * @author 夏露桂
 * @since 2021/1/14 10:14
 */
public abstract class AbstractService<T extends Entity<?, ?>, R extends Repository<T, ID>, ID> implements Service<T> {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected R repository;


}
