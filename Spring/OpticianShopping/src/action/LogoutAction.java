package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class LogoutAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i=0; i<cookies.length; i++){
				if(cookies[i].getName().startsWith("today")) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				}
			}
			
		}
		
		ActionForward forward = new ActionForward("logoutMember.jsp", false);
		return forward;
	}

}
