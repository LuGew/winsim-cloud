package com.lugew.winsimcloud.mybatis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lugew.winsmcloud.core.entity.Entity;
import com.lugew.winsmcloud.core.service.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author 夏露桂
 * @since 2021/1/20 14:29
 */
public abstract class AbstractService<M extends BaseMapper<T>, T extends Entity<ID>, ID extends Serializable> extends ServiceImpl<M, T> implements Service<T, ID> {
    @Override
    public boolean insert(T entity) {
        return save(entity);
    }

    @Override
    public boolean insert(List<T> entities) {
        return saveBatch(entities);
    }

    @Override
    public boolean update(T entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean delete(ID key) {
        return super.removeById(key);
    }

    @Override
    public T get(ID key) {
        return super.getById(key);
    }

    @Override
    public T get(T entity) {
        return super.getOne(new QueryWrapper<>(entity));
    }

    @Override
    public boolean exists(ID key) {
        return super.getById(key) != null;
    }

    @Override
    public List<T> getList(T entity) {
        return super.list(new QueryWrapper<>(entity));
    }

    @Override
    public Object getPagingList(T entity, int pageIndex, int pageSize) {
        return super.baseMapper.selectPage(new Page<>(pageIndex, pageSize), new QueryWrapper<>(entity));
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public int count(Wrapper<T> queryWrapper) {
        return super.count(queryWrapper);
    }
}
