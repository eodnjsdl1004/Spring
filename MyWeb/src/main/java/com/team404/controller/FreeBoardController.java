package com.team404.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.FreeBoardVO;
import com.team404.service.FreeBoardService;

@Controller
@RequestMapping("freeBoard")
public class FreeBoardController {

	/*
	 *  화면처리 -> 테이블 생성 -> 등록 처리
	 */
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/freeList")
	public String freeList(Model model) {
		
		List<FreeBoardVO> list = freeBoardService.getList();
		
		model.addAttribute("boardList", list);
		
		return "freeBoard/freeList";
	}

	@RequestMapping("/freeRegist")
	public String freeRegist() {
		
		return "freeBoard/freeRegist";
	}
	
	@RequestMapping(value="/registForm",method = RequestMethod.POST)
	public String registForm(FreeBoardVO vo,RedirectAttributes RA) {
		
		freeBoardService.regist(vo);
		
		// 등록 여부 반환 1회성 사용가능
		RA.addFlashAttribute("msg", "정상등록 처리 되었습니다.");
		
		return "redirect:/freeBoard/freeList";
	}
	
	@RequestMapping("/freeDetail")
	public String freeDetail(@RequestParam("bno") int bno, Model model) {
		FreeBoardVO vo = freeBoardService.getContent(bno);
		model.addAttribute("vo", vo);
		return "freeBoard/freeDetail";
	}
	
	
	@RequestMapping("/freeModify")
	public String freeModify(FreeBoardVO vo,Model model) {
		
		model.addAttribute("vo", vo);
		
		return "freeBoard/freeModify";
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(FreeBoardVO vo,RedirectAttributes RA) {
		
		int result = freeBoardService.getUpdate(vo);
		
		if(result == 0) {
			RA.addFlashAttribute("msg", "게시글 수정이 실패했습니다");
			return "redirect:/freeBoard/freeList";
		}else {
			RA.addFlashAttribute("msg", "게시글 수정이 정상 처리되었습니다");
			return "redirect:/freeBoard/freeList";
		}		
	}	
	
	@RequestMapping("/freeDelete")
	public String freeDelete(@RequestParam("bno") int bno,RedirectAttributes RA) {
		
		int result = freeBoardService.getDelete(bno);
		
		if(result==0) {
			RA.addFlashAttribute("msg", "게시글 삭제가 실패했습니다");
			return "redirect:/freeBoard/freeList";
		}else {
			RA.addFlashAttribute("msg", "게시글 삭제가 성공했습니다");
			return "redirect:/freeBoard/freeList";
		}
	}		
}
