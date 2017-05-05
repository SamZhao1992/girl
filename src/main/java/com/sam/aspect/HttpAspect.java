package com.sam.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SamZhao on 2017/5/5.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger looger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.sam.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        looger.info("url={}", request.getRequestURL());

        //method
        looger.info("method={}", request.getMethod());

        //ip
        looger.info("ip={}", request.getRemoteAddr());

        //类方法
        looger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        looger.info("class_parms={}", joinPoint.getArgs());
    }

    @After("log()")
    public void after(){
        looger.info("After");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void afterReturning(Object object){
        looger.info("respones={}", object);
    }
}
