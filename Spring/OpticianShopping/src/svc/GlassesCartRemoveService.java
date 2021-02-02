package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class GlassesCartRemoveService {
	public void cartRemove(HttpServletRequest request, int[] idArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for (int i = 0; i < idArray.length; i++) {
			for (int j = 0; j < cartList.size(); j++) {
				if(cartList.get(j).getId()==idArray[i]) {
					cartList.remove(cartList.get(j));
				}
				
			}
			
		}
	}
}
