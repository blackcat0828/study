package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GlassesCartRemoveService;
import vo.ActionForward;

public class CartRemoveAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] StringArray = request.getParameterValues("remove");
		int[] idArray = new int[StringArray.length];
		
		for(int i=0;i<StringArray.length; i++){ 
			idArray[i] = Integer.parseInt(StringArray[i]); 
			}
		
		GlassesCartRemoveService glassesCartRemoveService = new GlassesCartRemoveService();
		glassesCartRemoveService.cartRemove(request,idArray);
		ActionForward forward = new ActionForward("glassesCartList.glasses",true);
		return forward;
	}

}
