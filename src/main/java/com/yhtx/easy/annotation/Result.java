package com.yhtx.easy.annotation;

import java.lang.annotation.*;

/**
* @Description: 包装响应体注解
* @Author: zxy
* @Date: 15:06
*/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface Result {
}
