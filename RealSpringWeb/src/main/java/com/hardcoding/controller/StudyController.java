package com.hardcoding.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hardcoding.service.StudyService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

//@Slf4j // 무조건 string 타입
@Log4j
@RequestMapping("study")
@RestController // SpringFramework 4.3.x over에서만 사용가능 ResponseBody만 있을경우 사용
@RequiredArgsConstructor
public class StudyController {
	
	private final StudyService service;
    
    @GetMapping("testTransaction")
    public String testTransaction(Model model, HttpServletRequest req, HttpServletResponse res) {
        Map map = service.testTransaction(null);
        return "showMessage";
    }
	
//	@RequestMapping(value="getMessage1", method=RequestMethod.GET)
 // SpringFramework 4.3.x over에서만 사용가능 4.3다음 바로 5
//	@ResponseBody SpringFramework 4.3.x over에서만 사용가능
	// http://localhost:8080/study/getMessage1
	@GetMapping("getMessage1")
	public User getMessage1() { 
		log.info(" :: Study.getMessage1 ::");
		List<String> list = new ArrayList<>();
		User user = new User("빵형", "1", list);
		log.info(user); 
		return user;
		
	}
//	@ResponseBody
	@GetMapping("getMessage3")
	public Map getMessage3() {
		log.info(" :: Study.getMessage3 ::");
		Map<String, Object> map = new HashMap<>();
		map.put("name", "나도훈");
		map.put("no", "이연준");
		return map;
	}
	@GetMapping("getMembers") 
		public Map<String, Object> getMembers(@RequestParam Map<String, Object> param) {
		
			Map<String, Object> result = new HashMap<>();
			// List<Map<String, Object>> list = service.getMembers(param); 둘이 같다
			result.put("codeList", service.getMembers(param));

			return result;
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
