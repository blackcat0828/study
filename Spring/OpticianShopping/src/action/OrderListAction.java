package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.OrderListService;
import vo.ActionForward;
import vo.Order;

public class OrderListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				HttpSession session = request.getSession();
				String id = (String) session.getAttribute("userId");
				ArrayList<Order> orderList = null;
				OrderListService orderListService = new OrderListService();
				if(id.equals("admin")) {
					orderList = orderListService.getAllOrderList();
				}else {	
				
					orderList = orderListService.getOrderList(id);
				}
				
				request.setAttribute("orderList", orderList);
				ActionForward forward = new ActionForward("orderList.jsp", false);
				return forward;
	
	}
}
