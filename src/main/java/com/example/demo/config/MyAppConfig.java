package com.example.demo.config;

import com.example.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//指明当前类为配置类
public class MyAppConfig {
    //将方法的返回值添加到容器中，容器中组件id默认为方法名
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
