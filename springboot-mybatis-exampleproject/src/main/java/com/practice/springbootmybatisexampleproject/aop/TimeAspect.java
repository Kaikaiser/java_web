package com.practice.springbootmybatisexampleproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect // aop类
public class TimeAspect {

    @Pointcut("execution(* com.practice.springbootmybatisexampleproject.service.imp.EmpServiceImpl.get(..))") // .类/接口.方法
    public void pointcut() {}
    @Around ("pointcut()") // .类/接口.方法
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable
    {
        // 开始时间
        long begin = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        log.info("{} 执行耗时: {}ms", joinPoint.getSignature(), end - begin);
        return result;
    }
}
