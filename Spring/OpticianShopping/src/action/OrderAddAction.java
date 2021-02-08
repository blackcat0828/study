package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.GlassesCartListService;
import svc.OrderAddService;
import svc.UpdateMemberFormService;
import vo.ActionForward;
import vo.Cart;
import vo.Member;
import vo.Order;

public class OrderAddAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GlassesCartListService glassesCartListService = new GlassesCartListService();
		ArrayList<Cart> cartList = glassesCartListService.getCartList(request);
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		
		
		UpdateMemberFormService memberUpdateFormService = new UpdateMemberFormService();
		Member member = memberUpdateFormService.getMember(id);
		
		
		
		OrderAddService orderAddService = new OrderAddService();
		ArrayList<Order> orderList = orderAddService.getOrderList(member,cartList);
		
		session.removeAttribute("cartList");

		
		request.setAttribute("orderList", orderList);
		ActionForward forward = new ActionForward("orderList.jsp", false);
		return forward;
	}
	
}


