package com.stc.uploaddownloadfiles.model.enums;

import com.stc.uploaddownloadfiles.model.entity.File;
import lombok.AllArgsConstructor;
import lombok.Getter;



public enum PermissionLevel {
    VIEW("VIEW"),
    EDIT("EDIT");
    @Getter
    private final String name;

    PermissionLevel(String name){
        this.name = name;
    }

}
