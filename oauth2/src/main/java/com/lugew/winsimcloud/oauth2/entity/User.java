package com.lugew.winsimcloud.oauth2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 用户
 *
 * @author 夏露桂
 * @since 2021/1/11 16:53
 */
@Entity
@Getter
@Setter
public class User extends AbstractEntity<Long, Long> {

    private String name;

    private String password;

    private String nickname;

    @Id
    @Override
    public Long getId() {
        return super.getId();
    }
}
