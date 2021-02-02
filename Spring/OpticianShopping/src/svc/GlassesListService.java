package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GlassesDAO;
import vo.Glasses;

public class GlassesListService {
	//전체 리스트 표시
	public ArrayList<Glasses> getGlassesList() {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		ArrayList<Glasses> glassesList = glassesDAO.selectGlassesList();
		close(con);
		return glassesList;
	}
	
	//이름으로 검색
	public ArrayList<Glasses> getGlassesList(String kind) {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		ArrayList<Glasses> glassesList = glassesDAO.selectGlassesList(kind);
		close(con);
		return glassesList;
	}
	
	//최대 가격으로 검색
	public ArrayList<Glasses> getGlassesList(int endPrice) {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		ArrayList<Glasses> glassesList = glassesDAO.selectGlassesList(endPrice);
		close(con);
		return glassesList;
	}
	
}
