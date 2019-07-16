package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//标注一个主程序，说明这是一个spring boot应用
public class DemoApplication {

    public static void main(String[] args) {
        //spring应用启动起来
        SpringApplication.run(DemoApplication.class, args);
    }

}
