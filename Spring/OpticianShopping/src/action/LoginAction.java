package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginService;
import vo.ActionForward;

public class LoginAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginService loginService = new LoginService();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		boolean rightMember = loginService.memberCheck(userId, password);
		
		ActionForward forward = null;
		
		if(rightMember) {
			HttpSession session = request.getSession();
			session.setAttribute("userId",userId);
			forward = new ActionForward("glassesList.glasses", true);
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디나 패스워드가 일치하지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
			
		}
		

		return forward;
	}
}
