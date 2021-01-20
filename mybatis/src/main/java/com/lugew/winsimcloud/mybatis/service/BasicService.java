package com.lugew.winsimcloud.mybatis.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lugew.winsmcloud.core.entity.Entity;

import java.io.Serializable;

/**
 * @author 夏露桂
 * @since 2021/1/20 15:19
 */
public class BasicService<M extends BaseMapper<T>, T extends Entity<ID>, ID extends Serializable>
        extends AbstractService<M, T, ID> {
}
