package com.stc.uploaddownloadfiles.exceptions;

import com.stc.uploaddownloadfiles.model.enums.ErrorCode;

public class DBException extends RuntimeException{
    private final ErrorCode errorCode;

    public DBException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
