package com.example.petmeal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //컨트롤러 빈으로 등록
public class MainController {
	@RequestMapping("/") //시작 페이지
	public ModelAndView hello(ModelAndView mav) {
		mav.setViewName("main"); //뷰의 이름
		return mav; //화면 출력
	}
	
	@RequestMapping("/faq") //시작 페이지
	public ModelAndView faq(ModelAndView mav) {
		mav.setViewName("faq"); //뷰의 이름
		return mav; //화면 출력
	}
	
	@RequestMapping("/order") //시작 페이지
	public ModelAndView order(ModelAndView mav) {
		mav.setViewName("order"); //뷰의 이름
		return mav; //화면 출력
	}
}
