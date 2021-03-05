package org.fintech.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {
	
	@Before("execution(* org.fintech.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("#########################");
	}
	
	@After("execution(* org.fintech.service.SampleService*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info("======================");
	}

}
