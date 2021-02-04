package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GlassesDeleteService;
import vo.ActionForward;

public class GlassesDeleteAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		int id = Integer.parseInt(request.getParameter("id"));
		GlassesDeleteService glassesDeleteService = new GlassesDeleteService();
		boolean isOk = glassesDeleteService.deleteGlasses(id);
		if(isOk) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			forward = new ActionForward("glassesDelete.jsp", false);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
