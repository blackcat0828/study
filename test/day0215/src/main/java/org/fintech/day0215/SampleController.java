package org.fintech.day0215;

import java.util.ArrayList;

import org.fintech.domain.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

//현재 클래스가 컨트롤러 기능을 수행한다는 선언
@Controller
//URL 지정
//http://localhost:8080/sample/basic
//http://localhost:8080/sample/test
//http://localhost:8080/sample/insert
//http://localhost:8080/sample/delete
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping(value="/basic",
			        method = {RequestMethod.GET,RequestMethod.POST})
	public void basic() {
		log.info("basic get.......");
	}
	
	//전송방식이 get인 경우
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("getMapping annotation 테스트");
	}
	
	//전송방식이 get(주소창에서 매개변수가 보이게 처리)
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("SampleDTO test:" + dto);
		
		//views 폴더에 ex01.jsp를 실행해라
		return "ex01";
	}
	
	//@RequestParam?
	//주소창 URL에서 입력받은 매개변수의 값을 가져오는 경우 사용
	//http://localhost:8080/sample/ex02?name=이순신&age=25
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,
					   @RequestParam("age") int age) {
		
		log.info("이름:" + name);
		log.info("나이:" + age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(
			@RequestParam("numbers") ArrayList<String> numbers) {
		
		log.info("numbers:" + numbers);
		
		return "ex02List";
		
	}
	
	//http://localhost:8080/sample/ex04?name=홍길동&age=20&page=3
	//page=3 는 Model 객체에 값이 들어가지 않는 그냥 매개변수이므로
	//값 전달이 안됨
	
	//@ModelAttribute?
	//이 어노테이션으로 선언한 매개변수는 Model처리되어
	//JSP까지 값이 전달된다.
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto,@ModelAttribute("page") int page) {
		log.info("dto:" + dto);
		log.info("page:" + page);
		
		//views 폴더 아래에 sample 폴더에 있는 ex04.jsp를 실행해라
		return "/sample/ex04";
	}
	
	//@ResponseBody?
	//자바 객체를 http responsebody 형태로 변환처리
	//객체를 리턴하는데 JSON 형태로 출력한다.
	//http://localhost:8080/sample/ex06
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		
		log.info("ex06 테스트");
		
		SampleDTO dto = new SampleDTO();
		
		dto.setName("강감찬");
		dto.setAge(10);
		
		return dto;
		
	}
	
	
	
		
}








