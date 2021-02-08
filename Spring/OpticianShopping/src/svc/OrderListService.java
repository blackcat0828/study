package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GlassesDAO;
import vo.Order;

public class OrderListService {
	public ArrayList<Order> getOrderList(String id) {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		ArrayList<Order> orderList = glassesDAO.getOrder(id);
		close(con);
		return orderList;
	}
	
	public ArrayList<Order> getAllOrderList() {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		ArrayList<Order> orderList = glassesDAO.getOrderAdmin();
		close(con);
		return orderList;
	}
}
