package sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러 이고 Rest 방식을 이용한다는 선언
@RestController
public class HelloController {
	//http://localhost:8080/
	@RequestMapping("/")
	public String hello() {
		return "안녕하세요!";
	}
	
}
