package com.hardcoding.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hardcoding.common.util.CommonUtil;

@Controller
public class FreeBoardController {
	
	@RequestMapping(value = "freeboard", method = RequestMethod.GET)
	public String board(Model model, HttpServletRequest request) {
		
		return "freeBoard";
	}

}
