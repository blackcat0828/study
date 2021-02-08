package svc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.GlassesDAO;
import vo.Member;

public class UpdateMemberFormService {
	public Member getMember (String id){
		Member member = null;
		GlassesDAO glassesDAO = GlassesDAO.getInstance();
		Connection con = getConnection();
		glassesDAO.setConnection(con);
		member = glassesDAO.selectMember(id);
		
		return member;
	}
}
