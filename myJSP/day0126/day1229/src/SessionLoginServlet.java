import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//web.xml 을 가지고 지정하는 것과 동일한 효과
@WebServlet("/sessionLogin")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SessionLoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트가 요청한 값을 처리시 한글깨짐 방지
		request.setCharacterEncoding("UTF-8");
		//서버가 클라이언트에 응답처리시 한글깨짐 방지
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//Form에서 입력받은 값을 가져온다.
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		if(id.equals("java") && passwd.equals("java")) {
			//세션연결
			HttpSession session = request.getSession();
			
			//세션에 id라는 속성을 지정
			session.setAttribute("id",id);
			
//			RequestDispatcher 
//			- 현재 page에서 다른페이지로 이동하는 방법
//
//			1.forward
//			  - 현재 페이지에서 다른페이로 제어권이 완전히 넘어간다.
//			  - 서버상에서 직접 다른 페이지를 호출하는 방식이므로 페이지의
//			    이동속도가 빠르다.  
//
//			2.include
//			   - 현재페이지에서 다른 페이지로 제어권이 넘어갔다가 다른페이지
//			     수행후 다시 원래 페이지로 되돌아 온다.
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("menu.jsp");
			dispatcher.forward(request,response);
			
		}else {
			out.println("<script>");
			out.println("alert('아이디나 비밀번호가 일치하지 않습니다.')");
			//history.back()?
			//웹 브라우저가 세션 기록의 바로 이전 페이지로 이동
			//history.go(-1)
			out.println("history.back()");
			out.println("</script>");
		}
		
		
	}

}






