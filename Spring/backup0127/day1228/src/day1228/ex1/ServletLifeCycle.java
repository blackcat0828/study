package day1228.ex1;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeCycle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//기본생성자
	public ServletLifeCycle() {
		super();//부모클래스 HttpServlet 의 기본생성자를 호출
		System.out.println("Constructor");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 실행");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 실행");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 실행");
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("destroy 실행");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		System.out.println("init 실행");
	}

}
