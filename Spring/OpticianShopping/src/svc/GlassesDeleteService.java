package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.GlassesDAO;
import vo.Glasses;

public class GlassesDeleteService {
	public boolean deleteGlasses(int id) {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		boolean isRegistSuccess = false;
		int insertCount = glassesDAO.deleteGlasses(id);
		
		if(insertCount>0) {
			commit(con);
			isRegistSuccess = true;
		}else {
			rollback(con);
		}
		
		close(con);
		return isRegistSuccess;
	}
}