package com.lugew.winsimcloud.oauth2.service;

import com.lugew.winsmcloud.core.entity.Entity;
import com.lugew.winsmcloud.core.exception.Exception;
import com.lugew.winsmcloud.core.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 抽象CRUD业务逻辑层
 *
 * @author 夏露桂
 * @since 2021/1/14 11:09
 */
@Slf4j
public abstract class AbstractCrudService<T extends Entity<ID, ?>, R extends CrudRepository<T, ID>, ID>
        extends AbstractService<T, R, ID>
        implements CrudService<T, ID> {

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public <S extends T> S save(S entity) {
        preSave(entity);
        return repository.save(entity);
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        preSave(entities);
        return repository.saveAll(entities);
    }


    @Override
    public void deleteById(ID id) {
        T entity = (T) new Object();
        entity.setId(id);
        delete(entity);
    }

    @Override
    public void delete(T entity) {
        preDelete(entity);
        save(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        preDelete(entities);
        saveAll(entities);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> ids) {
        return repository.findAllById(ids);
    }


    protected <S extends T> void preSave(Iterable<S> entities) {
        Optional.ofNullable(entities).ifPresentOrElse(elements -> {
            for (S element : elements) {
                preSave(element);
            }
        }, () -> {
            throw new Exception("entities.cant.be.null");
        });
    }

    protected <S extends T> void preSave(S entity) {
        Optional.of(entity).map(T::getId).ifPresentOrElse(id -> {
            entity.setModifier(getUserId());
            entity.setModifyDateTime(LocalDateTime.now());
        }, () -> {
            entity.setCreator(getUserId());
            entity.setCreateDateTime(LocalDateTime.now());
            entity.setDeleted(false);
        });
    }

    protected <S extends T> void preDelete(Iterable<S> entities) {
        Optional.ofNullable(entities).ifPresentOrElse(elements -> {
            for (S element : elements) {
                preDelete(element);
            }
        }, () -> {
            throw new Exception("entities.cant.be.null");
        });
    }

    protected <S extends T> void preDelete(S entity) {
        Optional.of(entity).map(T::getId).ifPresentOrElse(id -> {
            entity.setDeleted(true);
        }, () -> {
            throw new Exception("delete.id.cant.be.null");
        });
    }

    public abstract <UID> UID getUserId();

}
