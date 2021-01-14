package com.lugew.winsimcloud.oauth2.repository;

import com.lugew.winsimcloud.oauth2.entity.Test;
import com.lugew.winsmcloud.core.repository.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author 夏露桂
 * @since 2021/1/14 10:12
 */
public interface TestRepository extends PagingAndSortingRepository<Test, Long>, Repository<Test> {
}
