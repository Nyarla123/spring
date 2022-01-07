package com.hardcoding.common.aspect;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class IpChkAspect {
	
	@Pointcut("execution(public * com.hardcoding.controller..*(..))")
	public void pointCutMethod() {}
	
	@Around("pointCutMethod()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		log.info("==================================================================");
		log.info("profiler == Before || " + joinPoint.getSignature().toShortString());
		log.info("profiler == Before toLongString || " + joinPoint.getSignature().toLongString());
		log.info("profiler == Before toString || " + joinPoint.getSignature().toString());
		log.info("== 이 시스템은 " + System.getProperty("spring.profiles.active") + "입니다");
		String addr = req.getRemoteAddr();
		log.info("== 서비스 요청 ip는 " + addr + "입니다");
		log.info("==================================================================");
//		ObjectMapper oMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();//oMapper.convertValue(joinPoint.getArgs()[0], Map.class);
		
		Object[] args = joinPoint.getArgs();
		for(Object obj : args) {
			map.put(obj.getClass().getName(), obj.toString());
		};
		
		Object result = new Object();
		try {
			result = joinPoint.proceed();
			req.setAttribute("ServerInfo", System.getProperty("spring.profiles.active"));
			map.put("SERVICE", req.getServletPath().replace("/", "")); // 요청 서비스 ID
			map.put("ACCESS_IP", addr); 							   // 서비스 요청 IP
			map.put("REQ_Query", req.getQueryString()); 			   // 요청 URL
			System.out.println(map);
			
		} catch(Exception e) {
			
		} 
			return result;
	}
}
