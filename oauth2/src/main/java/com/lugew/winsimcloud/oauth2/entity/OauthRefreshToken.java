package com.lugew.winsimcloud.oauth2.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import static javax.persistence.FetchType.LAZY;

/**
 * @author 夏露桂
 * @since 2021/1/12 17:14
 */
@Entity
@Data
public class OauthRefreshToken {
    @Id
    private String tokenId;
    @Lob()
    @Basic(fetch = LAZY)
    private byte[] token;
    @Lob()
    @Basic(fetch = LAZY)
    private byte[] authentication;
}
