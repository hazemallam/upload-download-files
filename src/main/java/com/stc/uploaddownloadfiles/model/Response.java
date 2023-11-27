package com.stc.uploaddownloadfiles.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.stc.uploaddownloadfiles.model.enums.ResponseStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Response <T>{
    private ResponseStatus status;
    private String message;

    private T data;

    private String errorCode;


    public Response(ResponseStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public Response(ResponseStatus status, String message, String errorCode) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
