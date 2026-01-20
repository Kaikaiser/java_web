package com.practice.springbootmybatisexampleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 对servlet组件的支持
@SpringBootApplication
public class SpringbootMybatisExampleprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisExampleprojectApplication.class, args);
    }

}
