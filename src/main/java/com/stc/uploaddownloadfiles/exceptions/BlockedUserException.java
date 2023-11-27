package com.stc.uploaddownloadfiles.exceptions;

import com.stc.uploaddownloadfiles.model.enums.ErrorCode;

public class BlockedUserException extends RuntimeException{
    private final ErrorCode errorCode;

    public BlockedUserException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
