package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

//인터페이스 = 추상메서드(메서드에 {} Body가 없다) + 상수
public interface Action  {
	ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}



