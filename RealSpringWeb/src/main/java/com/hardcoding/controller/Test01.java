package com.hardcoding.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {

	public static void main(String[] args) {
		
		List<Map<String, Object>> periodList = new ArrayList<Map<String, Object>>(); // 기간 목록
		List<Map<String, Object>> gradeList = new ArrayList<Map<String, Object>>(); // 직급 목록
						
		//period 기간
		Map<String, Object>
		map = new HashMap<>();map.put("CODE", "1d");map.put("VALUE", "1일");periodList.add(map);
		map.put("CODE", "1w");map.put("VALUE", "1주");periodList.add(map);
		map.put("CODE", "1m");map.put("VALUE", "1개월");periodList.add(map);
		map.put("CODE", "6m");map.put("VALUE", "6개월");periodList.add(map);
		map.put("CODE", "1y");map.put("VALUE", "1년");periodList.add(map);
		
		// grade 기간
		map = new HashMap<>();map.put("CODE", "01");map.put("VALUE", "수습사원");gradeList.add(map);
		map = new HashMap<>();map.put("CODE", "02");map.put("VALUE", "사원");gradeList.add(map);
		map = new HashMap<>();map.put("CODE", "03");map.put("VALUE", "대리");gradeList.add(map);
		map = new HashMap<>();map.put("CODE", "04");map.put("VALUE", "과장");gradeList.add(map);
		map = new HashMap<>();map.put("CODE", "05");map.put("VALUE", "차장");gradeList.add(map);
		map = new HashMap<>();map.put("CODE", "06");map.put("VALUE", "부장");gradeList.add(map);
		map = new HashMap<>();map.put("CODE", "07");map.put("VALUE", "이사");gradeList.add(map);
		map = new HashMap<>();map.put("CODE", "08");map.put("VALUE", "상무");gradeList.add(map);
		map = new HashMap<>();map.put("CODE", "09");map.put("VALUE", "사장");gradeList.add(map);
		
		System.out.println(periodList.toString());
		System.out.println(gradeList);
	}

}
