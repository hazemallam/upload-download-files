package com.stc.uploaddownloadfiles.model.enums;

public enum ErrorCode {

    STC_401("STC_401", "Folder already exists"),
    STC_999("STC_999", "Something went wrong"),
    STC_DB("STC_DB", "Please choose correct parent"),
    STC_BLOCK("STC_BLOCK", "You are blocked!");

    private final String code;
    private final String msg;

    ErrorCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
