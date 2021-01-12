package com.lugew.winsimcloud.oauth2.entity;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/**
 * @author 夏露桂
 * @since 2021/1/12 17:16
 */
@Entity
@Data
public class OauthCode {
    @Id
    private String code;
    @Lob()
    @Basic(fetch = LAZY)
    private byte[] authentication;
}
