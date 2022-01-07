package com.hardcoding.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.hardcoding.repository.CommonDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudyService {
	
	public final CommonDao dao;
	
	@Transactional
	public Map testTransaction(ModelMap model) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", "777");
		map.put("name", "아로미");
		// 1. 데이터 확인
		Map<String, Object> resultMap = dao.selectOne("study.selectItems", map);
		if(resultMap == null) {
			System.out.printf("id가 %s인 데이터는 존재하지 않습니다\n", map.get("id"));
		} else {
			System.out.printf("조회 결과 확인 :: " + resultMap.toString() + "\n");
		}
		
		//2. 데이터 insert
		dao.insert("study.insertItems", map);
		
		//3. 데이터 확인
		resultMap = dao.selectOne("study.selectItems", map);
		if(resultMap == null) {
			System.out.printf("id가 %s인 데이터는 존재하지 않습니다\n", map.get("id"));
		} else {
			System.out.printf("조회 결과 확인 :: " + resultMap.toString() + "\n");
		}
		
//		System.out.println("" + 1 / 0 );
		
		// 4.데이터 삭제
		System.out.println("입력된 데이터 삭제 " + map.toString());
		dao.delete("study.deleteItems", map);
		
		// 5. 데이터 확인
		resultMap = dao.selectOne("study.selectItems", map);
		if(resultMap == null) {
			System.out.printf("id가 %s인 데이터는 존재하지 않습니다\n", map.get("id"));
		} else {
			System.out.printf("조회 결과 확인 :: " + resultMap.toString() + "\n");
		}
		return resultMap;
	}
	
	@Transactional
	public String doReg(Map map) {
		String resultPage = "";
		// 1. 중복확인
		int cnt = dao.selectInt("study.existMembers", map);
		if(cnt > 0) {
			resultPage = "study/registFail";
		}
		
		// 2. 등록
		else {
			String password = (String)map.get("password");
			MessageDigest digest;
			try {
				digest = MessageDigest.getInstance("SHA-256");
				digest.update(password.getBytes());
				byte byteData[] = digest.digest();
				StringBuffer sb = new StringBuffer();
				for(byte byteTmp : byteData) {
					sb.append(Integer.toString((byteTmp&0xff) + 0x100, 16).substring(1));
				}
				map.put("password", sb.toString());
			} catch(NoSuchAlgorithmException e) {
				log.error(e.getMessage());
			}
			dao.insert("study.insertMember", map);
			resultPage = "study/registOK";
		}
		return resultPage;
	}
	
	@Transactional
	public List<Map<String, Object>> getMembers(Map params) {
		return dao.selectList("study.getMembers", params);
	}

}
