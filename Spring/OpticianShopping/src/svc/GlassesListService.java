package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GlassesDAO;
import vo.Glasses;

public class GlassesListService {
	public ArrayList<Glasses> getDogList() {
		GlassesDAO dogDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		dogDAO.setConnection(con);
		ArrayList<Glasses> dogList = dogDAO.selectGlassesList();
		close(con);
		return dogList;
	}
}
