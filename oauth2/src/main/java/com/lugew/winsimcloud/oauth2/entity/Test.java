package com.lugew.winsimcloud.oauth2.entity;

import com.lugew.winsimcloud.jpa.entity.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author 夏露桂
 * @since 2021/1/14 10:10
 */
@Entity
@Getter
@Setter
public class Test extends BasicEntity {
    private String name;
    private String content;
}
