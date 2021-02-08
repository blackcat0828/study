package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GlassesDAO;
import vo.Cart;
import vo.Glasses;

public class OrderDetailService {
	public ArrayList<Cart> getOrderDetails(int id) {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		ArrayList<Cart> cartList = glassesDAO.orderDetailPage(id);
		close(con);
		return cartList;
	}
	
}
