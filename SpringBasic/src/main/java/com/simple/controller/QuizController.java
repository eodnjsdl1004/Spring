package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.QuizVO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
	@RequestMapping("/sendBirth")
	public String sendBirth(QuizVO vo, Model model) {
		model.addAttribute("vo",vo);
		System.out.println(vo.getYear()+"년 "+vo.getMonth()+"월 "+vo.getDay()+"일");
		return "quiz/quiz01_ok";
	}
	
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
	@RequestMapping("/join")
	public ModelAndView join(@RequestParam("id") String id,
							 @RequestParam("pw") String pw,
							 @RequestParam("name") String name,
							 @RequestParam("email") String email) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("id", id);
		mav.addObject("pw", pw);
		mav.addObject("name", name);
		mav.addObject("email", email);
		
		mav.setViewName("quiz/quiz02_ok");
		
		return mav;
	}
	
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	
	@RequestMapping("/join2")
	public String join2(@ModelAttribute("id") String id,
						@RequestParam("pw") String pw,
						@RequestParam("pw_check") String pw_check,
						RedirectAttributes RA) {
		
		if(id.equals("")) {
			RA.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		}else if(!pw.equals(pw_check)) {
			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else {			
			return "quiz/quiz03_ok";			
		}
	}
	
}
