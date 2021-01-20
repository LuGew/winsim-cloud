package com.lugew.winsimcloud.jpa.service;

import com.lugew.winsmcloud.core.entity.Entity;
import com.lugew.winsmcloud.core.exception.Exception;
import com.lugew.winsmcloud.core.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * 抽象CRUD业务逻辑层
 *
 * @author 夏露桂
 * @since 2021/1/14 11:09
 */
@Slf4j
public abstract class AbstractService<T extends Entity<ID>, R extends JpaRepository<T, ID> & QuerydslPredicateExecutor<T>, ID>
        implements Service<T, ID> {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected R repository;

    @Override
    public int count() {
        return (int) repository.count();
    }

    @Override
    public boolean insert(T entity) {
        preInsert(entity);
        repository.saveAndFlush(entity);
        return true;
    }

    @Override
    public boolean insert(List<T> entities) {
        preInsert(entities);
        repository.saveAll(entities);
        return true;
    }


    @Override
    public boolean delete(ID id) {
        T entity = (T) new Object();
        entity.setId(id);
        preDelete(entity);
        return update(entity);
    }

    @Override
    public T get(ID id) {
        return repository.getOne(id);
    }

    @Override
    public T get(T entity) {
        return repository.findOne(Example.of(entity)).orElseThrow(() -> new Exception("entity.not.found"));
    }

    @Override
    public boolean exists(ID id) {
        return repository.existsById(id);
    }

    @Override
    public List<T> getList(T entity) {
        return repository.findAll(Example.of(entity));
    }

    @Override
    public boolean update(T entity) {
        repository.saveAndFlush(entity);
        return true;
    }

    @Override
    public Object getPagingList(T entity, int pageIndex, int pageSize) {
        return repository.findAll(Example.of(entity), PageRequest.of(pageIndex, pageSize));
    }

    protected <S extends T> void preInsert(List<S> entities) {
        Optional.ofNullable(entities).ifPresentOrElse(elements -> {
            for (S element : elements) {
                preInsert(element);
            }
        }, () -> {
            throw new Exception("entities.cant.be.null");
        });
    }

    protected void preInsert(T entity) {
        entity.setCreator(getUserId());
        entity.setCreateDateTime(LocalDateTime.now());
        entity.setDeleted(false);
    }

    protected void preUpdate(T entity) {
        entity.setModifier(getUserId());
        entity.setModifyDateTime(LocalDateTime.now());
    }

    protected void preDelete(T entity) {
        preUpdate(entity);
        entity.setDeleted(true);
    }


    public abstract Long getUserId();

}
