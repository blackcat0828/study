package org.fintech.day01;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		"file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OracleDataSourceTest {

	//오라클 접속 설정을 DI(의존적 주입)에 의해 가져온다.
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		
		try(Connection con = dataSource.getConnection()){
			log.info(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}








