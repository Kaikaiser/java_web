package com.practice.springbootmybatisexampleproject.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.practice.springbootmybatisexampleproject.mapper.OperateLogMapper;
import com.practice.springbootmybatisexampleproject.pojo.OperateLog;
import com.practice.springbootmybatisexampleproject.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.practice.springbootmybatisexampleproject.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 首先获取各个信息
        String jwt = request.getHeader("token");
        Claims claims = (Claims) JwtUtils.parseJwt(jwt);
        Integer operateUser = (Integer) claims.get("id");
        LocalDateTime operateTime = LocalDateTime.now();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        long begin = System.currentTimeMillis();

        // 执行目标方法
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long costTime = end - begin;
        // 返回值
        String returnValue = JSONObject.toJSONString(result);
        // 记录日志
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams,
                returnValue, costTime);
        log.info("aop记录操作日志: {}", operateLog);
        operateLogMapper.insert(operateLog);
        // 返回的是目标方法的值
        return result;
    }
}
