package com.stc.uploaddownloadfiles.exceptions;

import com.stc.uploaddownloadfiles.model.enums.ErrorCode;

public class FolderAlreadyExistException extends RuntimeException {

    private final ErrorCode errorCode;

    public FolderAlreadyExistException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
