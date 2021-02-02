package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GlassesCartAddService;
import vo.ActionForward;
import vo.Glasses;

public class CartAddAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GlassesCartAddService glassesCartAddService = new GlassesCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Glasses cartGlasses= glassesCartAddService.getCartGlasses(id);
		glassesCartAddService.addCart(request, cartGlasses);
		ActionForward forward = new ActionForward("glassesCartList.glasses", true);
		return forward;
	}
}
