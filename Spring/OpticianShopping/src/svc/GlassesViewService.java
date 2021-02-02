package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.GlassesDAO;
import vo.Glasses;

public class GlassesViewService {
	
	public Glasses getGlassesView(int id) {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		int updateCount = glassesDAO.updateReadCount(id);
		
		if(updateCount>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		Glasses glasses = glassesDAO.selectGlasses(id);
		close(con);
		return glasses;
	}
}
