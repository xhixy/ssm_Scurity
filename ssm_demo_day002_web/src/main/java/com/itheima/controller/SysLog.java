package com.itheima.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author 通知类
 */
@Component
@Aspect
public class SysLog {

    private Class aClass;
    private Method method;
    private Date beForetime;

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void toBefore(JoinPoint joinPoint){
        //反射获取目标类

    }
}
