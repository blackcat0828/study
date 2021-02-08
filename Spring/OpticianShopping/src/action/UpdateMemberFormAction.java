package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UpdateMemberFormService;
import vo.ActionForward;
import vo.Member;

public class UpdateMemberFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String MSG = (String)request.getAttribute("updateMSG");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		
		
		UpdateMemberFormService memberUpdateFormService = new UpdateMemberFormService();
		Member member = memberUpdateFormService.getMember(id);
		
		request.setAttribute("member", member);
		request.setAttribute("updateMSG", MSG);
		ActionForward forward = new ActionForward("updateMemberForm.jsp", false);
		return forward;
	}

}
