package com.lugew.winsimcloud.oauth2.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author 夏露桂
 * @since 2021/1/12 17:18
 */
@Entity
@Data
public class OauthApprovals {

    private String userId;
    private String clientId;
    private String scope;
    private String status;
    private LocalDateTime expiresAt;
    private LocalDateTime lastModifiedAt;
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
