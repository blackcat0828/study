package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GlassesCartRemoveService;
import vo.ActionForward;

public class CartRemoveAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] kindArray = request.getParameterValues("remove");
		GlassesCartRemoveService glassesCartRemoveService = new GlassesCartRemoveService();
		glassesCartRemoveService.cartRemove(request,kindArray);
		ActionForward forward = new ActionForward("glassesCartList.glasses",true);
		return forward;
	}

}
