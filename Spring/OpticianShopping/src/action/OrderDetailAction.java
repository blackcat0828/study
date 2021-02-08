package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.OrderDetailService;
import vo.ActionForward;
import vo.Cart;

public class OrderDetailAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int orderId = Integer.parseInt(request.getParameter("id"));
		String addr = request.getParameter("addr");
		OrderDetailService orderDetailService = new OrderDetailService();
		ArrayList<Cart> cartList = orderDetailService.getOrderDetails(orderId);
		//총금액 계산
		int totalMoney = 0;
		int money = 0;
		
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney += money;
			
		}
		
		request.setAttribute("addr", addr);
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		request.setAttribute("orderId", orderId);
		ActionForward forward = new ActionForward("orderDetailPage.jsp", false);
		return forward;
	
	}

}
