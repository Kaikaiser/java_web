package com.practice.springbootmybatisexampleproject.exception;

import com.practice.springbootmybatisexampleproject.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // 捕获所有异常
    public Result<String> handleException(Exception e) {
        e.printStackTrace();
        return Result.error("系统错误");
    }

}
