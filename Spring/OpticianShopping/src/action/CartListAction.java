package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GlassesCartListService;
import vo.ActionForward;
import vo.Cart;

public class CartListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GlassesCartListService glassesCartListService = new GlassesCartListService();
		ArrayList<Cart> cartList = glassesCartListService.getCartList(request);
		//총금액 계산
		int totalMoney = 0;
		int money = 0;
		
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney += money;
			
		}
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("glassesCartList.jsp", false);
		return forward;
	}
}
