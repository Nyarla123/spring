package com.hardcoding.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
//	@RequestMapping(value = "index", method = RequestMethod.GET)
	@GetMapping("index")
	public String index(Model model, HttpServletRequest request) {
						
		return "index";
	}

}
