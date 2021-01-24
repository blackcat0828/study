import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/program")
public class ProgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProgramServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트가 입력한 값을 한글처리
		request.setCharacterEncoding("UTF-8");
		
		String[] program = request.getParameterValues("lang");
		
		//서버가 클라이언트에게 응답처리시 UTF-8로 처리
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("선택한 과목:");
		
		for(int i=0;i<program.length;i++) {
			
			if(i==(program.length-1)) {//배열 마지막
				out.print(program[i]);
			}else {
				out.print(program[i]+",");
			}
			
		}
		
		
		
	}

}





