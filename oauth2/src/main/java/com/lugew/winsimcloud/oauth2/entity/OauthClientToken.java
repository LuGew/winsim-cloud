package com.lugew.winsimcloud.oauth2.entity;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/**
 * @author 夏露桂
 * @since 2021/1/12 17:07
 */
@Entity
@Data
public class OauthClientToken {
    @Id
    private String authenticationId;

    private String tokenId;
    @Lob()
    @Basic(fetch = LAZY)
    private byte[] token;

    private String userName;
    private String clientId;
}
