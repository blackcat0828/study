package action;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.DeleteMemberService;
import vo.ActionForward;

public class DeleteMemberAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		DeleteMemberService deleteMemberService = new DeleteMemberService();
		boolean isOk = deleteMemberService.deleteMember(id);
		if(isOk) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(int i=0; i<cookies.length; i++){
					if(cookies[i].getName().startsWith("today")) {
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
					}
				}
				
			}
			forward = new ActionForward("memberDelete.jsp", false);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	
	
	}
}
