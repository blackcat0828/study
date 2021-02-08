package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.OrderAddAction;
import action.OrderDeleteAction;
import action.OrderDetailAction;
import action.OrderListAction;
import action.UpdateStatusAction;
import vo.ActionForward;

@WebServlet("*.order")
public class OrderController extends HttpServlet {
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
		if(command.equals("/addOrder.order")) {
			action = new OrderAddAction();
			
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}				
		}else if(command.equals("/orderList.order")) {
			action = new OrderListAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/orderDelete.order")) {
			action = new OrderDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/orderDetail.order")) {
			action = new OrderDetailAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/updateOrderStatus.order")) {
			action = new UpdateStatusAction();
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
