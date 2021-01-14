package com.lugew.winsmcloud.core.service;

import com.lugew.winsmcloud.core.entity.Entity;

import java.util.Optional;

/**
 * @author 夏露桂
 * @since 2021/1/14 11:14
 */
public interface CrudService<T extends Entity<ID, ?>, ID> extends Service<T> {

    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    long count();

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> ids);

    void deleteById(ID id);

    void delete(T entity);

    void deleteAll(Iterable<? extends T> entities);

}
