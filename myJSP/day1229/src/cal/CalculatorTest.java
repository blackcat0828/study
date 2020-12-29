package cal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalculatorTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		PrintWriter out = response.getWriter();
		out.println("첫번째 숫자: "+num1+"<br>");
		out.println("두번째 숫자: "+num2+"<br><br>");
		out.println(num1+" + "+num2 +" = " + (num1+num2)+"<br>");
		out.println(num1+" - "+num2 +" = " + (num1-num2)+"<br>");
		out.println(num1+" * "+num2 +" = " + (num1*num2)+"<br>");
		out.println(num1+" / "+num2 +" = " + (num1/num2)+"<br>");
		
	}

}
