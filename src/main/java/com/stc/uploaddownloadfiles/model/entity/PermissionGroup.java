package com.stc.uploaddownloadfiles.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "permission_group")

public class PermissionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String groupName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
