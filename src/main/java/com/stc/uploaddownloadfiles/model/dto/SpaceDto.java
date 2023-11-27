package com.stc.uploaddownloadfiles.model.dto;

public class SpaceDto {
    private String name;
    private Long permissionGroup;

    private String path;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPermissionGroup() {
        return permissionGroup;
    }

    public void setPermissionGroup(Long permissionGroup) {
        this.permissionGroup = permissionGroup;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
