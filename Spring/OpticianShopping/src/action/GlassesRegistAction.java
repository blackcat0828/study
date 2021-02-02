package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.GlassesRegistService;
import vo.ActionForward;
import vo.Glasses;

public class GlassesRegistAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GlassesRegistService glassesRegistService = new GlassesRegistService();
		//String realFolder = "C:\\study\\Spring\\OpticianShopping\\WebContent\\resources\\images";
		//파일 업로드될 서버 상의 물리적인 경로
		
		String realFolder = "";
		String saveFolder = "/resources/images";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		//한번에 업로드 할수 있는 파일 크기
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		System.out.println(realFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, 
				new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image");
		Glasses glasses = new Glasses(0, 
						multi.getParameter("kind"),
						Integer.parseInt(multi.getParameter("price")),
						image,
						multi.getParameter("brand"),
						multi.getParameter("content"),
						0);
		
		boolean isRegistSuccess = glassesRegistService.registGlasses(glasses);
		ActionForward forward = null;
		
		if(isRegistSuccess) {
			forward = new ActionForward("glassesList.glasses", true);
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
			
		}
		
		return forward;
	}
	
	
}
