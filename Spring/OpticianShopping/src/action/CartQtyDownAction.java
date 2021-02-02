package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GlassesCartQtyDownService;
import vo.ActionForward;

public class CartQtyDownAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		GlassesCartQtyDownService glassesCartQtyDownService = new GlassesCartQtyDownService();
		glassesCartQtyDownService.downCartQty(kind,request);
		ActionForward forward = new ActionForward("glassesCartList.glasses",true);
		return forward;
	}

}
