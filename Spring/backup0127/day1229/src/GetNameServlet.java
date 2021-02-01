import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getName")
public class GetNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//세션에 있는 name이라는 속성을 삭제처리
		session.removeAttribute("name");
		
		session.setAttribute("name","이순신");
		
		//이름이라는 속성값을 가져옴
		//getAttribute() 리턴값은 Object 이므로 String으로 캐스팅
		String  name = (String)session.getAttribute("name");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>속성 name의 값:" + name + "</h1>");
		
		
	}

}



