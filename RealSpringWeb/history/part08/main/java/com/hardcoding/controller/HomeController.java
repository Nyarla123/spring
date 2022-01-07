package com.hardcoding.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardcoding.common.util.CommonUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String home(Model model, HttpServletRequest req, HttpServletResponse res) {
		Locale locale = new Locale("ko","KR");
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		String sComboScript = CommonUtil.getSelect();
//		System.out.println(1 / 0);
		model.addAttribute("serverTime", formattedDate);
		req.setAttribute("samki", "Fighting!!");
		req.setAttribute("combo", sComboScript);

		return "home";
	}
	
	@GetMapping("study/registForm")  
	public void registForm() { // void면 위에 mapping정보로 파일을 찾음
		
	}
	
	@PostMapping("study/doReg")
	public String doReg(@RequestParam Map<String, String> map) {
		System.out.println("paraMeter :: " + map.toString());
		return "study/registOK";
	}
	
}
