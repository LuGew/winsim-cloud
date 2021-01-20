package com.lugew.winsimcloud.web;

import com.lugew.winsmcloud.core.controller.Controller;
import com.lugew.winsmcloud.core.entity.Entity;
import com.lugew.winsmcloud.core.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 夏露桂
 * @since 2021/1/15 15:36
 */

@Standard
public abstract class AbstractController<T extends Entity<ID>, S extends Service<T, ID>, ID> implements Controller<T, ID> {
    @Autowired
    @SuppressWarnings("ALL")
    protected S service;

    @PostMapping({"/getList"})
    public List<T> getList(@RequestBody T entity) {
        return service.getList(entity);
    }


    @Override
    @PostMapping("/getPagingList")
    public Object getPagingList(T entity, int pageIndex, int pageSize) {
        return service.getPagingList(entity, pageIndex, pageSize);
    }

    @Override
    @GetMapping({"/get"})
    public T get(ID id) {
        return service.get(id);
    }

    @Override
    @PostMapping({"/add"})
    public boolean add(@RequestBody T entity) {
        return service.insert(entity);
    }

    @Override
    @PostMapping({"/update"})
    public boolean update(@RequestBody T entity) {
        return service.update(entity);
    }

    @Override
    @PostMapping({"/delete"})
    public boolean delete(ID id) {
        return service.delete(id);
    }
}
