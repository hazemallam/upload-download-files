package com.stc.uploaddownloadfiles.model.enums;

import lombok.Getter;

public enum ItemType {

    SPACE("SPACE"),
    FOLDER("FOLDER"),
    FILE("FILE");


    @Getter
    private final String name;

    ItemType(String name){
        this.name = name;
    }

}
