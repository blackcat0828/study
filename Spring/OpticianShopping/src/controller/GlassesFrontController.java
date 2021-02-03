package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.CartAddAction;
import action.CartListAction;
import action.CartQtyDownAction;
import action.CartQtyUpAction;
import action.CartRemoveAction;
import action.CartSearchAction;
import action.GlassesListAction;
import action.GlassesRegistAction;
import action.GlassesRegistFormAction;
import action.GlassesViewAction;
import vo.ActionForward;

//안경 상품 관련 컨트롤러
@WebServlet("*.glasses")
public class GlassesFrontController extends HttpServlet {
       

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
		if(command.equals("/glassesList.glasses")) {
			action = new GlassesListAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}				
		}
		else if(command.equals("/glassesView.glasses")) {
			action = new GlassesViewAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesCartAdd.glasses")) {
			action = new CartAddAction();
	
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesCartList.glasses")) {
			action = new CartListAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesCartSearch.glasses")) {
	
			action = new CartSearchAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesCartRemove.glasses")) {
			action = new CartRemoveAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesCartQtyUp.glasses")) {
			action = new CartQtyUpAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesCartQtyDown.glasses")) {
			action = new CartQtyDownAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesRegist.glasses")) {
			action = new GlassesRegistAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesRegistForm.glasses")) {
			action = new GlassesRegistFormAction();
			//프로젝트명+기능+형태(?)
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
