package com.dotin.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

   private boolean isActive;
   private boolean isDisabled;
    private int version;
    private Date modification;

    public BaseEntity() {
    }

    public BaseEntity(boolean isActive, boolean isDisabled, int version, Date modification) {
        this.isActive = isActive;
        this.isDisabled = isDisabled;
        this.version = version;
        this.modification = modification;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getModification() {
        return modification;
    }

    public void setModification(Date modification) {
        this.modification = modification;
    }
}
