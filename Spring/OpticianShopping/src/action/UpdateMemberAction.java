package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UpdateMemberService;
import vo.ActionForward;
import vo.Member;

public class UpdateMemberAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UpdateMemberService updateMemberService = new UpdateMemberService();
		Member member = new Member(request.getParameter("id"),
						request.getParameter("password"),
						request.getParameter("name"),
						request.getParameter("contact"),
						request.getParameter("addr"));
		
		boolean isRegistSuccess = updateMemberService.updateMember(member);
		ActionForward forward = null;
		
		if(isRegistSuccess) {
			request.setAttribute("updateMSG", "수정 완료");
			forward = new ActionForward("updateMemberForm.member", false);
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 실패');");
			out.println("history.back();");
			out.println("</script>");
			
		}
		
		return forward;
		
	}
}
