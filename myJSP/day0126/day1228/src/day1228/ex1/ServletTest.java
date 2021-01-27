package day1228.ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿을 사용하려면 HttpServlet 상속
public class ServletTest extends HttpServlet {
	
	//자바 버전 관리 선언
	private static final long serialVersionUID = 1L;

	//클라이언트의 전송방식이 get방식이면 doGet() 실행되고
	//전송방식이 post방식이면 doPost() 실행된다.
	//HttpServletRequest:클라이언트가 서버로 요청한 데이터 처리를 위한 클래스
	//HttpServletResponse:서버가 클라이언트에게 응답처리를 위한 클래스
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//이파일의 ContentType이 html임을 선언
		resp.setContentType("text/html");
		
		//한글 깨짐 방지 선언
		resp.setCharacterEncoding("UTF-8");
		
		//현재시간을 알기 위해 Calendar 클래스 이용
		Calendar c = Calendar.getInstance();
		
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		//문자단위 스트림
		//예를들면 ObjectOutputStream 와 같이
		//클래스 이름이 Stream으로 끝나면 바이트 단위 입출력 스트림이다.
		PrintWriter out = resp.getWriter();
		
		out.write("<HTML><HEAD><TITLE>Servlet</TITLE></HEAD>");
		out.write("<BODY><H1>");
		
		out.write("현재시각은");
		
		//정수형 시분초를 문자열로 변환
		out.write(Integer.toString(hour));
		out.write("시 ");
		
		out.write(Integer.toString(minute));
		out.write("분 ");
		
		out.write(Integer.toString(second));
		out.write("초 입니다.");
		
		out.write("</H1></BODY></HTML>");
		
		out.close();

	}

}
