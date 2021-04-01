package org.hdcd.controller;

import org.hdcd.dto.MemberAuth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestConstroller {
	@GetMapping("/users/me")
	public ResponseEntity<Object> getUserInfo() throws Exception{
		log.info("JWT 접근 테스트");
	
		MemberAuth member = new MemberAuth("hi@testim.com", "ADMIN");
		
		return new ResponseEntity<>(member, HttpStatus.OK);
	}
	
}
