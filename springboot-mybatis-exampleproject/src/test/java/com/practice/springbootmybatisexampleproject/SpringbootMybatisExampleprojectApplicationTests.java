package com.practice.springbootmybatisexampleproject;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.swing.plaf.SpinnerUI;
import java.security.Signature;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest
class SpringbootMybatisExampleprojectApplicationTests {

//    @Test
//    void contextLoads() {
//    }


    @Test
    public void test01(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("username","tom");
        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, "123456")
                .setExpiration(new Date(System.currentTimeMillis()+1000*1000))
                .compact();
        System.out.println(jwt);
    }

//    @Test
//    public void test02(){
//        Claims claims = Jwts.parser()
//                .setSigningKey("123456")
//                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzY4ODk2MzU5LCJ1c2VybmFtZSI6InRvbSJ9.45hD61G6wlLNlC0T0QaQOxz3vEPTCKMT0YMXuEOfmE0")
//                .getBody();
//        System.out.println(claims);
//    }
//
//
//    @Test
//    public void test03(){
//        Integer a = 10;
//        System.out.println("a="+a);
//
//    }
}
