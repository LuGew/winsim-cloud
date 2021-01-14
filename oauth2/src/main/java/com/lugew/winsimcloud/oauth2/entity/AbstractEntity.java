package com.lugew.winsimcloud.oauth2.entity;

import com.lugew.winsmcloud.core.entity.Entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class AbstractEntity<I extends Serializable, U extends Serializable> implements Entity<I, U> {
    protected I id;
    protected U creator;
    protected U modifier;
    protected LocalDateTime createDateTime;
    protected LocalDateTime modifyDateTime;
    protected Boolean deleted;

    @Override
    @Id
    public I getId() {
        return id;
    }

    @Override
    public void setId(I id) {
        this.id = id;
    }

    @Override
    public U getCreator() {
        return creator;
    }

    @Override
    public void setCreator(U creator) {
        this.creator = creator;
    }

    @Override
    public U getModifier() {
        return modifier;
    }

    @Override
    public void setModifier(U modifier) {
        this.modifier = modifier;
    }

    @Override
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    @Override
    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    @Override
    public LocalDateTime getModifyDateTime() {
        return modifyDateTime;
    }

    @Override
    public void setModifyDateTime(LocalDateTime modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    @Override
    public Boolean getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
