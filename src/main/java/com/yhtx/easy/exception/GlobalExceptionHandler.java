package com.yhtx.easy.exception;

import com.yhtx.easy.result.ErrorResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {


    // 拦截抛出的异常，@ResponseStatus：用来改变响应状态码
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResponseData handlerThrowable(Throwable e, HttpServletRequest request) {
        return new ErrorResponseData(ExceptionEnum.SYSTEM_ERROR.getCode().toString(),e.getMessage());
    }

    // 参数校验异常
    @ExceptionHandler(BindException.class)
    public ErrorResponseData handleBindExcpetion(BindException e, HttpServletRequest request) {
        return new ErrorResponseData(ExceptionEnum.PARAM_IS_INVALID.getCode().toString(),ExceptionEnum.PARAM_IS_INVALID.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseData handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        return new ErrorResponseData(ExceptionEnum.PARAM_IS_INVALID.getCode().toString(),ExceptionEnum.PARAM_IS_INVALID.getMessage());
    }
}