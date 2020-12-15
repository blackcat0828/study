package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { 
				"/sinit", 
				"/sinit2" //urlPatterns를 이용해 매핑 이름을 여러 개 설정할 수 있다.
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "admin@jweb.com"), 
				@WebInitParam(name = "tel", value = "010-1111-2222")
				//@WebInitParam을 이요해 여러 개의 매개변수를 설정할 수 있다.
		})
public class initParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		//설정한 매개변수의 name으로 값을 가져옴
		out.print("<html><body>");
		out.print("<table><tr>");
		out.print("<td>email: </td><td>"+email+"</td></tr>");
		out.print("<tr><td>휴대전화: </td><td>"+tel+"</td>");
		out.print("</tr></table></body></html>");
	
	}

}
