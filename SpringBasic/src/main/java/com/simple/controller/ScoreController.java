package com.simple.controller;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ScoreVO;
//import com.simple.dao.ScoreDAO;
import com.simple.service.ScoreService;
//import com.simple.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {
	
//1st
// 직접 new로 생성 ScoreService scoreService = new ScoreServiceImpl();

//2nd
//<beans:bean id="serviceImpl" class="com.simple.service.ScoreServiceImpl"/>
//빈을 직접 생성해서 자동으로 추가하는 작업
//		@Resource(name="serviceImpl")
//		@Autowired		
//		private ScoreService service;
	
//3rd
//@Controller,@Service, @Component, @Repositoty 자동 생성 어노테이션을 붙이고
//해당 패키지를 스캔명령으로 읽어서 빈으로 생성후에 자동 주입 명령
		@Autowired 	
		private ScoreService scoreService;		
		
		@RequestMapping("/scoreRegist")
		public void scoreRegist() {
			
		}
		
		//점수 등록 요청
		@RequestMapping("/scoreForm")
		public String scoreForm(ScoreVO vo) {
			
			//service처리			
			scoreService.ScoreRegist(vo);			
			System.out.println("score");
			
			return "service/scoreResult";
		}
		
		//점수 화면 요청
		@RequestMapping("/scoreList")
		public String scoreList(Model model) {
			
			model.addAttribute("list",scoreService.scoreList());
			
			return "service/scoreList";
		}
		
		//점수 삭제 요청
		@RequestMapping("scoreDelete")
		public String scoreDelete(@RequestParam("num") int num,
								  RedirectAttributes RA) {
			
//			if(scoreService.scoreDelete(num)) {
//				return "redirect:/service/scoreList";
//			}
//			else {
//				return "redirect:/service/scoreList";
//			}
			scoreService.scoreDelete(num);
			
			return "redirect:/service/scoreList";
		}
}
