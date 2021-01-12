package com.lugew.winsimcloud.oauth2.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 夏露桂
 * @since 2021/1/12 10:12
 */
@Entity
@Data
public class OauthClientDetails {

    @Id
    private String clientId;
    private String resourceIds;
    private String clientSecret;
    private String scope;
    private String authorizedGrantTypes;
    private String webServerRedirectUri;
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    @Column(length = 4095)
    private String additionalInformation;

    private String autoapprove;

}
