package svc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.GlassesDAO;
import vo.Glasses;

public class GlassesUpdateFormService {
	public Glasses getItem (int id){
		Glasses glasses = null;
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		glasses = glassesDAO.selectGlasses(id);
		
		return glasses;
	}
}
