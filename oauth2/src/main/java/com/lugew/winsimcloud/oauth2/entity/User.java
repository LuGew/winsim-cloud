package com.lugew.winsimcloud.oauth2.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 夏露桂
 * @since 2021/1/11 16:53
 */
@Entity
@Data
public class User {
    @Id
    private Long id;

    private String name;

    private String password;
}
