package com.lugew.winsmcloud.core.controller;

import com.lugew.winsmcloud.core.entity.Entity;

import java.util.List;

/**
 * 控制层接口
 *
 * @author 夏露桂
 * @since 2021/1/14 10:07
 */
public interface Controller<T extends Entity<ID>, ID> {

    List<T> getList(T entity);

    Object getPagingList(T entity, int pageIndex, int pageSize);

    T get(ID id);

    boolean add(T entity);

    boolean update(T entity);

    boolean delete(ID id);
}
