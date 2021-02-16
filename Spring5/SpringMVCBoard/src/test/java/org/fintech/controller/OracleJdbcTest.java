package org.fintech.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class OracleJdbcTest {

	static {
		
		try {
			//Class 클래스로  forName을 이용하여 OracleDriver를
			//리턴한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//오라클 연동 테스트
	@Test
	public void testConnection() {
		try(Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl",
				"board",
				"board1234")){
			log.info(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}




