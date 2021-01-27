import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalculatorTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CalculatorTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Form에서 입력받은 두수를 문자열에서 숫자형으로 변환처리
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		//문자단위 출력 스트림
		PrintWriter out = response.getWriter();
		
		DecimalFormat df = new DecimalFormat("###,###");
		
		out.print(num1 + "+" + num2 + "=" + df.format(num1 + num2) + "\n");
		out.print(num1 + "-" + num2 + "=" + df.format(num1 - num2) + "\n");
		out.print(num1 + "*" + num2 + "=" + df.format(num1 * num2) + "\n");
		out.print(num1 + "/" + num2 + "=" + df.format(num1 / num2));
		
		
		
	}

}





