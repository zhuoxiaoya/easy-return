package com.yhtx.easy.conf;

import com.yhtx.easy.interceptor.ResultInterCepTer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ResultInterCepTer resultInterCepTer(){
        return new ResultInterCepTer();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(resultInterCepTer()).addPathPatterns("/**");
    }
}