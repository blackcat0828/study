package org.fintech.day01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class OracleJdbcTest {
	
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testConnection() throws SQLException {
		try(Connection con = DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:orcl",
				"fadmin",
				"fadmin1234")){
			log.info(con);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
