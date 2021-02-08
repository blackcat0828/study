package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UpdateStatusService;
import vo.ActionForward;

public class UpdateStatusAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		UpdateStatusService updateStatusService = new UpdateStatusService();
		
		
		boolean isRegistSuccess = updateStatusService.updateOrderStatus(orderId);
		ActionForward forward = null;
		
		if(isRegistSuccess) {
			forward = new ActionForward("orderList.order", false);
			
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
