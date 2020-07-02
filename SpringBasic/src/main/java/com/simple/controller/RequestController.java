package com.simple.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.command.ReqVO;

@Controller //component scan이 해당 어노테이션을 알아서 빈으로 생성
//모든 요청은 컨트롤러로 들어가게 된다
@RequestMapping("/request")
public class RequestController {
	
	//이 메서드를 실행시키고 싶다면 /request/req_ex01 요청을 화면에서 호출합니다.
	//폴더명을 맞춰서 요청 경로를 기술하는 편이 좋습니다.
	//void 형이라면 호출된 url과 동일한 페이지로 연결.	
//	@RequestMapping("/req_ex01")
//	public void req_ex01(){
//		//return "/request/req_ex01";
//	}
	
	@RequestMapping("/req_ex01")
	public String req_ex01(){
		return "request/req_ex01";
	}
//	
//	@RequestMapping(value="/basic1", method = RequestMethod.GET)
//	public void basic1(){
//		System.out.println("basic1요청");
//	}
//	
//	@RequestMapping(value="/basic2", method = RequestMethod.POST)
//	public void basic2(){
//		System.out.println("basic2요청");
//	}
//	
//	@GetMapping("/basic3")
//	public void basic3(){
//		System.out.println("basic3요청");
//	}
//	
//	@PostMapping("/basic4")
//	public void basic4(){
//		System.out.println("basic4요청");
//	}
	
	//동일한 요청을 맵핑하나로 처리하고 싶다면 {}중괄호로 묶어주면 됩니다.
	@RequestMapping({"/basic1","/basic2","basic3"})
	public void view() {
		System.out.println("실행요청");
	}
	
	@RequestMapping("/req_ex02")
	public String req_ex02() {
		return "request/req_ex02";
	}
	
	//param 호출
	//1st
//	@RequestMapping(value="/param", method=RequestMethod.POST)
//	public String param(HttpServletRequest request) {
//		
//		System.out.println(request.getParameter("id"));
//		
//		return "request/req_ex02_result";
//	}
	
	//param 호출
	//2nd
	@RequestMapping("/param")
	public String param(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						@RequestParam("name") String name, 
						@RequestParam("age") int age,
						@RequestParam(value="inter", required=false, defaultValue="") ArrayList<String> inter) {
		
		System.out.println(id+" "+pw+" "+name+" "+age);

		//필수가 아닌 파라미터일 경우 required=false를 통해 null값을 지정하게 되는데
		//기본값의 설정으로 defaultValue옵션을 사용하면 됩니다.
		System.out.println(inter.toString());
		return "request/req_ex02_result";
	}
	
//	@RequestMapping("/param")
//	public String param(ReqVO vo) {
//		
//		System.out.println(vo.getId()+" "+vo.getPw()+" "+vo.getName()+" "+vo.getAge());
//		vo.getInter().forEach((s)->System.out.println(s));
//		
//		return "request/req_ex02_result";
//	}
	@RequestMapping("/req_quiz01")
	public void req_quiz01() {
		
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("id") String id,
					  @RequestParam("pw") String pw) {
		if(id.equals("abc123")&&pw.equals("xxx123")) {
			return "request/req_quiz01_ok"; 
		}else {
			return "request/req_quiz01_no";
		}
	}
	
}
