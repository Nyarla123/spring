package com.hardcoding.common.aspect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Aspect
@Component
public class IpChkAspect {
	
	@Pointcut("execution(public * com.hardcoding.controller..*(..))")
	public void pointCutMethod() {}
	
	@Around("pointCutMethod()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpServletResponse res = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getResponse();
//		ServletWebRequest servletContainer = (ServletWebRequest)RequestContextHolder.getRequestAttributes();
//		HttpServletRequest req = servletContainer.getRequest();
//		HttpServletResponse res = servletContainer.getResponse();
		
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
			List<String> list = new ArrayList<>(Arrays.asList("index", "loginForm", "login"));
			if(!list.contains(joinPoint.getSignature().getName())) {
				HttpSession session = req.getSession(true);
				log.info("session id :: " + session.getId());
				if(session.getAttribute("userAuth") == null) {
					log.info("로그인 해야 함");
					res.sendRedirect(req.getContextPath() + "/nosession/loginForm");
				}
				else {
					log.info("로그인 되었음..!!" + session.toString());
				}
			}
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
