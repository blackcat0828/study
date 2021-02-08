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
import action.GlassesDeleteAction;
import action.GlassesListAction;
import action.GlassesRegistAction;
import action.GlassesRegistFormAction;
import action.GlassesUpdateAction;
import action.GlassesUpdateFormAction;
import action.GlassesViewAction;
import vo.ActionForward;

//안경 상품 관련 컨트롤러
@WebServlet("*.glasses")
public class GlassesFrontController extends HttpServlet {
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
		if(command.equals("/glassesList.glasses")) {
			action = new GlassesListAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}				
		}
		else if(command.equals("/glassesView.glasses")) {
			action = new GlassesViewAction();
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
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesCartRemove.glasses")) {
			action = new CartRemoveAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesCartQtyUp.glasses")) {
			action = new CartQtyUpAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesCartQtyDown.glasses")) {
			action = new CartQtyDownAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesRegist.glasses")) {
			action = new GlassesRegistAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/glassesRegistForm.glasses")) {
			action = new GlassesRegistFormAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/glassesUpdateForm.glasses")) {
			action = new GlassesUpdateFormAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/glassesUpdate.glasses")) {
			action = new GlassesUpdateAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/glassesDelete.glasses")) {
			action = new GlassesDeleteAction();
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
