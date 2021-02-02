package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GlassesCartSearchService;
import vo.ActionForward;
import vo.Cart;

public class CartSearchAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GlassesCartSearchService glassesCartSearchService = new GlassesCartSearchService();
		int startMoney = Integer.parseInt(request.getParameter("startMoney"));
		int endMoney = Integer.parseInt(request.getParameter("endMoney"));

		ArrayList<Cart> cartList = glassesCartSearchService.getCartSearchList(startMoney,endMoney,request);
		request.setAttribute("cartList", cartList);
		request.setAttribute("startMoney", startMoney);
		request.setAttribute("endMoney", endMoney);
		int totalMoney = 0;
		int money = 0;
		
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney += 0;
		}
		
		request.setAttribute("totalMoney", totalMoney);
		ActionForward forward = new ActionForward("glassesCartList.jsp", false);
		return forward;
	}
	

}
