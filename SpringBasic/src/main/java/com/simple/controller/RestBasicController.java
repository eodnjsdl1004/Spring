package com.simple.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple.command.TestVO;

@RestController
public class RestBasicController {

	//1. @RestController는 기본적으로 return에 실린 값이 리졸버 뷰로 전달되는 게 아니라 요청된 주소로 반환됩니다.
	//2. @CrossOrigin은 다른 서버에 대해서 요청을 허용한다.
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/getText", produces = "text/plain; charset=utf-8")//application/json;제이슨형식
	public String getTest() {
		return "안녕하세요";
	}
	
	//객체변환(반드시 젝슨 바인딩 라이브러리가 필요)
	@GetMapping("/getObject")
	public TestVO getObject() {
		return new TestVO(1,"홍길동","kkk123");		
	}
	
	//값을 받고, 객체로 변환
	@GetMapping("/getCollection")
	public List<TestVO> getCollection(@RequestParam("num") String num){
		List<TestVO> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			TestVO vo = new TestVO(i,"홍길동","kkk123"+num);
			list.add(vo);
		}
		
		return list;
	}
	
	// /값/값/값 형태로 받고 Map으로 반환
	@GetMapping("/getPath/{id}/{pw}/{name}")
	public Map<String,TestVO> getPath(@PathVariable("id") String id, @PathVariable("pw") String pw,@PathVariable("name") String name){
		Map<String,TestVO> map = new HashMap<>();
		TestVO vo = new TestVO(Integer.parseInt(pw),name,id);
		map.put("info", vo);
		
		return map;
	}
	
	//json으로 받고 객체로 변환
	//구글 확장 프로그램 rest Client
	@PostMapping("/getJson")
	public List<TestVO> getJson(@RequestBody TestVO vo){
		List<TestVO> list = new ArrayList<>();
		list.add(vo);
		TestVO testVO = new TestVO(2,"김길동","aaa123");
		list.add(vo);
		list.add(testVO);
		return list;
	}
	
	
}
