package com.practice.springbootmybatisexampleproject.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {


    private static String JWT_SECRET = "123456"; // 密钥
    private static long JWT_EXPIRATION = 1000 * 60 * 10; // 过期时间

    /**
     * 生成令牌
     *
     * @param claims
     * @return
     */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .compact();
    }


    /**
     * 解析令牌
     * @param jwt
     * @return
     */
    public static Map<String, Object> parseJwt(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
