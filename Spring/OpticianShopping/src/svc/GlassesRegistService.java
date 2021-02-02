package svc;

import java.sql.Connection;

import dao.GlassesDAO;

import static db.JdbcUtil.*;
import vo.Glasses;

public class GlassesRegistService {
	public boolean registGlasses(Glasses glasses) {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		boolean isRegistSuccess = false;
		int insertCount = glassesDAO.insertGlasses(glasses);
		
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
