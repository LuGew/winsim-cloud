package com.lugew.winsimcloud.oauth2.service;

import com.lugew.winsmcloud.core.entity.Entity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 抽象分页、排序业务逻辑接口
 *
 * @author 夏露桂
 * @since 2021/1/14 18:29
 */
public abstract class AbstractPagingAndSortingService<T extends Entity<ID, ?>, R extends PagingAndSortingRepository<T, ID>, ID>
        extends AbstractCrudService<T, R, ID> {
}
