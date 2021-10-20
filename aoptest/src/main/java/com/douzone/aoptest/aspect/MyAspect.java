package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("---- BeforeAdvice ----");
	}
	
	@After("execution(* *..*.ProductService.find(..))")
	public void AfterAdvice() {
		System.out.println("---- AfterAdvice ----");
	}
	
	
	@AfterReturning("execution(* *..*.ProductService.*(..))")
	public void AfterReturningAdvice() {
		System.out.println("----AfterReturning Advice ----");
	}
	
	
	@AfterThrowing(value = "execution(* *..*.ProductService.*(..))", throwing="ex")
	public void AfterThrowingAdvice(Throwable ex) {
		System.out.println("----AfterThrowing Advice : "+ ex + " ----");
		
	}
	
	@Around("execution(* *..*.ProductService.*(..))")
	public Object AroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		//before
		System.out.println("----Around(before) Advice ----");
		
		//PointCut Method 실행
		
		//파라미터 가로채기
		//TV를 넣어서 실행했는데, 파라미터를 가져가서 바뀜
		//Object[] params = {"Camera"};
		//Object result = pjp.proceed(params);
		
		Object result = pjp.proceed();
		
		//after
		System.out.println("----Around(after) Advice ----");
	
		return result;
	}


}
