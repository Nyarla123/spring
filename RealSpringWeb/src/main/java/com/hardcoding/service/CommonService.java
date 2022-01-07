package com.hardcoding.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardcoding.repository.CommonDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // slf4j는 문자열만 가능 Log4j는 컬렉션도 가능
@Service
@RequiredArgsConstructor
public class CommonService {
	
	@Autowired
	public final CommonDao dao;
	
	@Transactional
	public List<Map<String, Object>> getCodeList(Map params) {
		return dao.selectList("common.selectItems", params);
	}
	
	public Map<String, Object> getData(String statement, Map condition) {
		Map<String, Object> result = dao.selectOne(statement, condition);
		return result;
	}
	
	public List<Map<String, Object>> getDataList(String statement, Map condition) {
		List<Map<String, Object>> resultList = dao.selectList(statement, condition);
		return resultList;
	}

	public Map<String, Object> getUserInfo(Map<String, Object> param) {
		return dao.selectOne("common.getUserInfo", param);
	}
}
