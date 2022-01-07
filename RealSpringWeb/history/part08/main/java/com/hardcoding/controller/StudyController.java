package com.hardcoding.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

//@Slf4j // 무조건 string 타입
@Log4j
@RequestMapping("study")
@RestController // SpringFramework 4.3.x over에서만 사용가능 ResponseBody만 있을경우 사용
public class StudyController {

//	@RequestMapping(value="getMessage1", method=RequestMethod.GET)
	@GetMapping("getMessage1") // SpringFramework 4.3.x over에서만 사용가능 4.3다음 바로 5
//	@ResponseBody SpringFramework 4.3.x over에서만 사용가능
	public User getMessage1() { // http://localhost:8080/study/getMessage1
		log.info(" :: Study.getMessage1 ::");
		List<String> list = new ArrayList<>();
		User user = new User("빵형", "1", list);
		log.info(user); 
		return user;
		
	}
	@GetMapping("getMessage3")
//	@ResponseBody
	public Map getMessage3() {
		log.info(" :: Study.getMessage3 ::");
		Map<String, Object> map = new HashMap<>();
		map.put("name", "나도훈");
		map.put("no", "이연준");
		return map;
	}
	
//	@GetMapping("registForm")
//	public String registForm() {
//		return "study/registForm";
//	}
	
//	@GetMapping("home") // InternalResourceViewResolver
//	public String home() {
//		return "study/home";
//	}
	
}
@Data
@AllArgsConstructor
class User {
	private String name;
	private String no;
	List list;
}
