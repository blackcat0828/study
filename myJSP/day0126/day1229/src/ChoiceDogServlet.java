import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/choiceDog")
public class ChoiceDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChoiceDogServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//체크박스에서 선택한 값들을 가져오는 메서드
		//체크박스에서 선택한 이미지명을 배열에 대입
		String[] dog = request.getParameterValues("dog");
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body bgcolor='black'>");
		out.println("<table align='center' bgcolor='yellow'>");
		out.println("<tr>");
		
		//String 배열에 대입한 이미지명을 가져오기
		//length : 배열의 크기
		for(int i=0;i<dog.length;i++) {
			
			out.println("<td>");
			out.println("<img src='"+dog[i]+"'/>");
			out.println("</td>");
		}
		
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

}






