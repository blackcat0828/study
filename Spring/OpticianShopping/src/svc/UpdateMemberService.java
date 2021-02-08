package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.GlassesDAO;
import vo.Member;

public class UpdateMemberService {
	public boolean updateMember(Member member) {
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		boolean isRegistSuccess = false;
		int insertCount = glassesDAO.updateMember(member);
		
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
