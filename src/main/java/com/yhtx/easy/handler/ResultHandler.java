package com.yhtx.easy.handler;

import com.yhtx.easy.annotation.Result;
import com.yhtx.easy.result.ErrorResponseData;
import com.yhtx.easy.result.SuccessResponseData;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResultHandler implements ResponseBodyAdvice<Object> {

    //标记
    private static String RESULT_ANN = "RESULT-ANN";

    //判断请求是否包含注解标记，没有就直接返回，不需要重写返回体
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //判断请求是否包含包装标记
        Result result = (Result) request.getAttribute(RESULT_ANN);
        return result == null ? false : true;
    }

    //重写返回体
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(body instanceof ErrorResponseData){
            ErrorResponseData error = (ErrorResponseData) body;
            return new ErrorResponseData(error.getCode(),error.getMessage());
        }else {
            return new SuccessResponseData(body);
        }
    }
}