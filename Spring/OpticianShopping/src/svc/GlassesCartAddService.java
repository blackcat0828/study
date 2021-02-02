package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.GlassesDAO;
import vo.Cart;
import vo.Glasses;

public class GlassesCartAddService {
	
	public Glasses getCartGlasses(int id) {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		Glasses glasses = glassesDAO.selectGlasses(id);
		close(con);
		return glasses;
	}
	
	public void addCart(HttpServletRequest request, Glasses cartGlasses) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		//지금 장바구니에 담는 항목이 새로 추가되는 항목인지를 저장할 변수
		for (int i = 0; i < cartList.size(); i++) {
			if(cartGlasses.getKind().equals(cartList.get(i).getKind())) {
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
			}
			
		}
		
		if(isNewCart) {
			Cart cart = new Cart();
			cart.setImage(cartGlasses.getImage());
			cart.setKind(cartGlasses.getKind());
			cart.setPrice(cartGlasses.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
	}

}
