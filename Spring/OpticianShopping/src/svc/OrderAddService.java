package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GlassesDAO;
import vo.Cart;
import vo.Member;
import vo.Order;

public class OrderAddService {
	public ArrayList<Order> getOrderList(Member member, ArrayList<Cart> cartList) {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		ArrayList<Order> orderList = null;
 		int insertCount = glassesDAO.addOrder(member);
		
		if(insertCount>0) {
			
			orderList = glassesDAO.getOrder(member.getId());
			
		}else {
			rollback(con);
		}
		
		int orderId = glassesDAO.getCurrentOrderId(member.getId());
		
		for(int i = 0; i < cartList.size(); i++) {
			int insertItemCount = 0;
			insertItemCount = glassesDAO.addOrderedItem(orderId, cartList.get(i).getId(), cartList.get(i).getQty());
			
			
			if(insertItemCount>0) {
				commit(con);
			}else {
				rollback(con);
			}
			
		}
		
		
		close(con);
		return orderList;
	}
}
