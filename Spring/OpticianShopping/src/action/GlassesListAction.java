package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GlassesListService;
import vo.ActionForward;
import vo.Glasses;

public class GlassesListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> todayImageList = new ArrayList<String>();
		Cookie[] cookieArray = request.getCookies();
		
		if(cookieArray != null) {
			for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")) {
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		
		
		GlassesListService glassesListService = new GlassesListService();
		ArrayList<Glasses> glassesList = null;
		
		String searchType = request.getParameter("searchType");
		
		if(searchType!=null) {
		if(searchType.equals("종류")){
			String searchValue = request.getParameter("searchValue");
			glassesList = glassesListService.getGlassesList(searchValue);
		}else if(searchType.equals("최대가격")){
			int searchValue = Integer.parseInt(request.getParameter("searchValue"));
			glassesList = glassesListService.getGlassesList(searchValue);
		}
		}else {
			glassesList = glassesListService.getGlassesList();
		}
		
		
		request.setAttribute("glassesList", glassesList);
		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward("glassesList.jsp", false);
		return forward;
	
	}

}
