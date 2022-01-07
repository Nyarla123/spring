package com.hardcoding.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hardcoding.repository.CommonDao;
import com.hardcoding.service.BoardService;
import com.hardcoding.service.CommonService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {
	
	private final CommonService commonService;
	private final BoardService service;
	private final CommonDao dao;
	
	@GetMapping("writeForm1")
	public String writeForm1() {
		return "board/writeForm1";
	}
	
	@GetMapping("tuiGridForm")
	public String tuiGridForm() {
		return "board/tuiGridForm";
	}
	
	@GetMapping("writeForm2")
	public void writeForm2() {
		
	}
	@GetMapping("writeForm3")
	public String writeForm3() {
		return "board/writeForm3";
	};
	
	@PostMapping("upload")
	public String upload(Model model, MultipartHttpServletRequest req, HttpServletResponse res) {
		return service.upload(req);
	}
	
	@PostMapping("upload2")
	public String upload2(MultipartHttpServletRequest req) {
		return service.upload2(req);
	}
	
	@ResponseBody
	@PostMapping("upload3")
	public Map upload3(MultipartHttpServletRequest req) {
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> resultList = service.upload3(req);
		System.out.println("resultList" + resultList);
		result.put("files", resultList);
		return result;
	}
	
		@RequestMapping("getFileDownload")
		public ModelAndView getFileDownload(@RequestParam Map<String, String> map) throws Exception {
			Map fileMap = commonService.getData("board.getFileInfo", map);
			String path = "";
			if(fileMap != null) {
				path = fileMap.get("FILE_PATH").toString() 
					 + fileMap.get("FILE_NAME").toString();
			}
			File downloadFile = new File(path);
			Map<String, Object> data = new HashMap<>();
			data.put("model", downloadFile);
			data.put("FILE_REALNAME", fileMap.get("FILE_REALNAME"));
			
			return new ModelAndView("downloadView", "downloadFile", data);
		}
		
		@ResponseBody
		@GetMapping("getBasicDummy")
		public ResponseEntity<?> getBasicDummy() {
			
			List<Map<String, Object>> result = new ArrayList<>();
			Map<String, Object> param = new HashMap<>();
//			param.put("GROUP_KEY", "GROUP_KEY");
//			param.put("FILE_KEY", "FILE_KEY");
//			param.put("FILE_REALNAME", "Twenty One Pilots");
//			param.put("FILE_NAME", "2015.05.19");
//			param.put("FILE_PATH", "EP");
//			param.put("FILE_LENGTH", "2");
//			param.put("FILE_TYPE", "Rock");
//			param.put("REG_ID", "2");
//			param.put("REG_DATE", "1");
//			param.put("price", "13000");
//			param.put("downloadCo1unt", "1000");
//			param.put("listenCount", "5000");
			
			result = dao.selectList("board.getFiles", param);
//			System.out.println("result "+ result);
//			System.out.println("param "+ param);
//			{"files":[{"FILE_REALNAME":"IMG_0834.JPG","FILE_LENGTH":401481,"GROUP_KEY":"D4968110DF3A0FE3E053020011AC08CB","USER_ID":null,"FILE_TYPE":"image/jpeg","FILE_PATH":"c:\\NAS\\","FILE_NAME":1641113465483,"FILE_KEY":1}]}
			
			final HttpHeaders httpHeaders= new HttpHeaders();
		    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		    return new ResponseEntity(result, httpHeaders, HttpStatus.OK);
		}
}
