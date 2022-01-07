package com.hardcoding.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("ajax")
public class AjaxController {

	@RequestMapping("toastList")
	public List<String> toastList() {
		
		List list = new ArrayList<>();
		Map map = new HashMap<>();
		map.put("name", "a");
		map.put("artist","b");
		map.put("type", "c");
		map.put("release", "1.1.1.0");
		map.put("genre", "M");
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		return list;
	}
	
	@RequestMapping("toastDataList")
	public List toastDataList() {
		List list = new ArrayList<>();
		Data1 data = new Data1("a", "b", "c" ,"1.1.1.0" ,"M");
		list.add(data);
		data = new Data1("d", "e", "f" ,"1.1.1.2" ,"W");
		list.add(data);
		data = new Data1("g", "h", "i" ,"1.1.1.3" ,"M");
		list.add(data);
		data = new Data1("j", "k", "l" ,"1.1.1.4" ,"M");
		list.add(data);
		return list;
		
	}
	
}
@Getter
@Setter
@AllArgsConstructor
class Data1 {
	
	private String name;
	private String artist;
	private String type;
	private String release;
	private String genre;
	
}
