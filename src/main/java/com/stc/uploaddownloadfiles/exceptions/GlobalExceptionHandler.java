package com.stc.uploaddownloadfiles.exceptions;


import com.stc.uploaddownloadfiles.model.Response;
import com.stc.uploaddownloadfiles.model.enums.ErrorCode;
import com.stc.uploaddownloadfiles.model.enums.ResponseStatus;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    String expMsg = "Exception occurred: ";

    @ExceptionHandler(FolderAlreadyExistException.class)
    protected Object handleFolderAlreadyExists(FolderAlreadyExistException ex){
        Response<Object> response = new Response<Object>(ResponseStatus.FAIL, ex.getErrorCode().getMsg(), ex.getErrorCode().getCode());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(DBException.class)
    protected Object handleDbException(DBException ex){
        Response<Object> response = new Response<Object>(ResponseStatus.FAIL, ex.getErrorCode().getMsg(), ex.getErrorCode().getCode());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(BlockedUserException.class)
    protected Object handleBlockedUserException(BlockedUserException ex){
        Response<Object> response = new Response<Object>(ResponseStatus.FAIL, ex.getErrorCode().getMsg(), ex.getErrorCode().getCode());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected Object handleBadCredentialException(BadCredentialsException ex){
        Response<Object> response = new Response<>(ResponseStatus.FAIL, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(Exception.class)
    protected Object handleGenericException(Exception ex){
        Response<Object> response = new Response<Object>(ResponseStatus.FAIL, ErrorCode.STC_999.getMsg(), ErrorCode.STC_999.getCode());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
