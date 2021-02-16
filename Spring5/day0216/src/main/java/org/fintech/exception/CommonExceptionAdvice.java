package org.fintech.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;
//@Controller 혹은 @RestController가 선언된 클래스에서 발생한 예외처리를
//감지하고 적절한 응답을 처리해주는 어노테이션
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	//어떤 예외가 발생하면 처리해 줄건지 선언
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("예외발생" + ex.getMessage());
		model.addAttribute("exception",ex);
		log.error(model);
		
		return "error_page";
	}
}
