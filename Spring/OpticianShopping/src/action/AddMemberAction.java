package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AddMemberService;
import vo.ActionForward;
import vo.Member;

public class AddMemberAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AddMemberService addMemberService = new AddMemberService();
		Member member = new Member(request.getParameter("id"),
						request.getParameter("password"),
						request.getParameter("name"),
						request.getParameter("contact"),
						request.getParameter("addr"));
		
		boolean isRegistSuccess = addMemberService.registMember(member);
		ActionForward forward = null;
		
		if(isRegistSuccess) {
			HttpSession session = request.getSession();
			session.setAttribute("userId",request.getParameter("id"));
			forward = new ActionForward("glassesList.glasses", true);
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
			
		}
		
		return forward;
		
	}
}
