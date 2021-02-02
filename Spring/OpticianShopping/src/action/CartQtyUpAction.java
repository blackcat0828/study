package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GlassesCartQtyUpService;
import vo.ActionForward;

public class CartQtyUpAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		GlassesCartQtyUpService glassesCartQtyUpService = new GlassesCartQtyUpService();
		glassesCartQtyUpService.upCartQty(kind,request);
		ActionForward forward = new ActionForward("glassesCartList.glasses",true);
		return forward;
	
	}

}
