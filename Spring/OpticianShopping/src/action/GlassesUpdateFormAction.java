package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GlassesUpdateFormService;
import vo.ActionForward;
import vo.Glasses;

public class GlassesUpdateFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		
		GlassesUpdateFormService glassesUpdateFormService = new GlassesUpdateFormService();
		Glasses glasses = glassesUpdateFormService.getItem(id);
		
		request.setAttribute("glasses", glasses);
		ActionForward forward = new ActionForward("updateForm.jsp", false);
		return forward;
	}

}
