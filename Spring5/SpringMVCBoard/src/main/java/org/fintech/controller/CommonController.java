package org.fintech.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	
	//Authentication(인증)
	//Authorization(권한부여=인가)
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		
		log.info("access Denied:" + auth);
		
		//jsp에서 ${msg} => EL(Expression Language, 표현언어) 
		model.addAttribute("msg","Access Denied !!!");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		
		if(error != null) {
			model.addAttribute("error","당신의 로그인 아이디를 혹은 비밀번호를 확인하세요");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃 성공");
		}
	}
	
}
