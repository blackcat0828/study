package org.hdcd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@RequestMapping("/notice")
@Controller
public class NoticeController {

	@RequestMapping("/list")
	public void list() {
		log.info("list : access to all");
	}

	@RequestMapping("/register")
	public void registerForm() {
		log.info("registerForm : access to admin");
	}

}
