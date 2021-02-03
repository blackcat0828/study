package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.LoginAction;
import action.LoginFormAction;
import action.LogoutAction;
import vo.ActionForward;

//맴버 관리 관련 컨트롤러
@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String requestURI = request.getRequestURI();
		//요청 URL : http://localhost:8080/boardProject/boardWriterForm.bo
		//requestURI : /boardProject/boardWriteForm.bo 반환

		String contextPath = request.getContextPath();
		// /boardProject 반환
		
		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;
		
		//각 요청별로 비지니스 로직 호출
		if(command.equals("/loginForm.member")) {
			action = new LoginFormAction();
			
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}				
		}else if(command.equals("/login.member")) {
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/logout.member")) {
			System.out.println("로그아웃컨트롤");
			action = new LogoutAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}

		
		if(forward !=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	
	}

}
