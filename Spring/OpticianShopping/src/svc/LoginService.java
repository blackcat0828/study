package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.GlassesDAO;
import vo.Glasses;

public class LoginService {
	public boolean memberCheck(String id, String password) {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		boolean isRightMember = false;
		int checkCount = glassesDAO.checkMember(id, password);
		
		if(checkCount>0) {
			
			isRightMember = true;
		}
		
		close(con);
		return isRightMember;
	}
}
