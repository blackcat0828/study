package board.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

//프로젝트내 모든 클래스에서 발생하는 예외처리를 해주기 위해 선언한다.
@ControllerAdvice
public class ExceptionHandler {
	
	//LogBack을 이용한 로깅 처리
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ModelAndView defaultExceptionHandler(HttpServletRequest request,Exception exception) {
		
		//예외처리 발생시 templates > error 폴더에 있는 error_default.html 실행
		ModelAndView mv = new ModelAndView("/error/error_default");
		//예외처리 메시지를 속성 exception에 대입
		mv.addObject("exception",exception);
		
		log.error("exception",exception);
		
		return mv;
		
	}
}