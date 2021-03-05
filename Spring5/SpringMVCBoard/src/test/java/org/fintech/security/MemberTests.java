package org.fintech.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
public class MemberTests {
	@Setter(onMethod_ = @Autowired)
	private DataSource ds;
	
	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	
	@Test
	public void testInsertMemberAuth() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into tbl_member_auth(userid,auth) values(?,?)";
		
		for(int i=0;i<100;i++) {
			try {
				con = ds.getConnection();
				
				pstmt = con.prepareStatement(sql);

				
				if(i<80) {
					pstmt.setString(1, "user"+i);
					pstmt.setString(2, "ROLE_USER");
				}else if(i<90) {
					pstmt.setString(1, "manager"+i);
					pstmt.setString(2, "ROLE_MANAGER");
				}else {
					pstmt.setString(1, "admin"+i);
					pstmt.setString(2, "ROLE_ADMIN");
				}
				
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
		}
	}
	
	
	@Ignore
	public void testInsertMember() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into tbl_member(userid,userpw,username) values(?,?,?)";
		
		for(int i=0;i<100;i++) {
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(2, pwencoder.encode("pw"+i));
				if(i<80) {
					pstmt.setString(1, "user"+i);
					pstmt.setString(3, "일반사용자"+i);
				}else if(i<90) {
					pstmt.setString(1, "manager"+i);
					pstmt.setString(3, "관리자"+i);
				}else {
					pstmt.setString(1, "admin"+i);
					pstmt.setString(3, "어드민"+i);
				}
				
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
		}
	}
	
	
	
}
