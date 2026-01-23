package com.practice.springbootmybatisexampleproject.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.parsers.SAXParser;

@Configuration
public class CommonConfig {

    @Bean
    public SAXReader saxReader(){
        return new SAXReader();
    }
}
