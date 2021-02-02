package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GlassesViewService;
import vo.ActionForward;
import vo.Glasses;

public class GlassesViewAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GlassesViewService glassesViewService = new GlassesViewService();
		int id = Integer.parseInt(request.getParameter("id"));
		Glasses glasses = glassesViewService.getGlassesView(id);
		request.setAttribute("glasses", glasses);
		Cookie todayImageCookie = new Cookie("today"+id, glasses.getImage());
		todayImageCookie.setMaxAge(60*60*24);
		response.addCookie(todayImageCookie);
		ActionForward forward = new ActionForward("glassesView.jsp",false);
		return forward;
	}

}
