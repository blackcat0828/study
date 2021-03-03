package org.fintech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample")
public class SecuritySampleController {
	
	@GetMapping("/all")
	public String doAll() {
		return "/sample/all";
	}
	
	@GetMapping("/member")
	public String doMember() {
		return "/sample/member";
	}
	
	@GetMapping("/admin")
	public String doAdmin() {
		return "/sample/admin";
	}
}
