package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.GlassesUpdateService;
import vo.ActionForward;
import vo.Glasses;

public class GlassesUpdateAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GlassesUpdateService glassesUpdateService = new GlassesUpdateService();
		ActionForward forward = null;
		//String realFolder = "C:\\study\\Spring\\OpticianShopping\\WebContent\\resources\\images";
		//파일 업로드될 서버 상의 물리적인 경로
		
		String realFolder = "";
		String saveFolder = "/resources/images";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		//한번에 업로드 할수 있는 파일 크기
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, 
				new DefaultFileRenamePolicy());
		
		//업로드한 사진이 없을때
		if(multi.getContentType("image")==null) {
			Glasses glasses = new Glasses(
					Integer.parseInt(multi.getParameter("id")), 
					multi.getParameter("kind"),
					Integer.parseInt(multi.getParameter("price")),
					multi.getParameter("originalImage"),
					multi.getParameter("brand"),
					multi.getParameter("content"),
					0);
	
				boolean isRegistSuccess = glassesUpdateService.updateGlasses(glasses);
				
				
				if(isRegistSuccess) {
					forward = new ActionForward("glassesView.glasses?id="+glasses.getId(), true);
					
				}else {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('등록실패');");
					out.println("history.back();");
					out.println("</script>");
					
				}
			
			
		}
		//업로드한 사진이 있을때
		else {
		
		String image = multi.getFilesystemName("image");
		
		System.out.println("멀티파트테스트" + multi.getContentType("image"));
		Glasses glasses = new Glasses(
						Integer.parseInt(multi.getParameter("id")), 
						multi.getParameter("kind"),
						Integer.parseInt(multi.getParameter("price")),
						image,
						multi.getParameter("brand"),
						multi.getParameter("content"),
						0);
		
		boolean isRegistSuccess = glassesUpdateService.updateGlasses(glasses);
		
		
		if(isRegistSuccess) {
			forward = new ActionForward("glassesView.glasses?id="+glasses.getId(), true);
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
			
		}
		}
		
		return forward;
	}

}
