package com.yhtx.easy.interceptor;

import com.yhtx.easy.annotation.Result;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class ResultInterCepTer implements HandlerInterceptor {

    //标记
    private static String RESULT_ANN = "RESULT-ANN";

    @Override
    public boolean  preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if(handler instanceof HandlerMethod){
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            //判断当前请求方法上是否有响应注解
            if(clazz.isAnnotationPresent(Result.class)){
                request.setAttribute(RESULT_ANN,clazz.getAnnotation(Result.class));
            }else if (method.isAnnotationPresent(Result.class)){
                request.setAttribute(RESULT_ANN,method.getAnnotation(Result.class));
            }
        }
        return true;
    }
}