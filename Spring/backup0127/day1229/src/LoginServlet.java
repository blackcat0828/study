

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//어노테이션을 사용하여 Url 패턴 지정
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//기본생성자
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request : 내장객체
		//웹브라우저에서 서버의 JSP 페이지로 전달하는 정보를 저장한다
		//즉 Form 태그에서 입력된 데이터를 전달하는 요청 매개변수 값을
		//getParameter() 메서드를 이용하여 JSP 페이지로 가져온다.
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		response.setContentType("text/html;charset=utf-8");
		
		//문자단위 출력 스트림
		PrintWriter out = response.getWriter();
		
		out.println("아이디:" + id + "<br>");
		out.println("비밀번호:" + passwd + "<br>");
		
	}


}
