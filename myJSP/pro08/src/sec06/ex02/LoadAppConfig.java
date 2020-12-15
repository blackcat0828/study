package sec06.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loadConfig", urlPatterns = { "/loadConfig" }, loadOnStartup = 1)
//loadOnStartup 속성을 추가하고 우선순위를 1로 설정
public class LoadAppConfig extends HttpServlet {
	
	private ServletContext context; //변수 선언
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadAppConfig의 init 메서드 호출");
		String menu_member = context.getInitParameter("menu_member");
		String menu_order= context.getInitParameter("menu_order");
		String menu_goods= context.getInitParameter("menu_goods");
		//getInitParameter() 메서드로 web.xml의 메뉴 정보를 읽는다.
		context.setAttribute("menu_member", menu_member);
		context.setAttribute("menu_order", menu_order);
		context.setAttribute("menu_goods", menu_goods);
		//메뉴 정보를 ServletContext 객체에 바인딩
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String menu_member = (String) context.getAttribute("menu_member");
		String menu_order= (String) context.getAttribute("menu_order");
		String menu_goods= (String) context.getAttribute("menu_goods");
		//브라우저에서 욫ㅇ 시 ServletContext 객체의 바인딩된 메뉴 항목을 가져옴
		out.print("<html><body>");
		out.print("<table border=1 cellspaction=0><tr>메뉴 이름</tr>");
		out.print("<tr><td>"+menu_member + "</td></tr>");
		out.print("<tr><td>"+menu_order + "</td></tr>");
		out.print("<tr><td>"+menu_goods + "</td></tr>");
		out.print("</tr></table></body></html>");
	}

}
