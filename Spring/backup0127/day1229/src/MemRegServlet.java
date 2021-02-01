import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memReg")
public class MemRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemRegServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		//한글깨짐 방지
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		//Form 태그에서 입력한 값을 가져온다.
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		String hobby = request.getParameter("hobby");
		
		out.println("이름:" + name + "<br>");
		out.println("주소:" + addr + "<br>");
		out.println("전화번호:" + tel + "<br>");
		out.println("취미:" + hobby + "<br>");
		
	}

}




