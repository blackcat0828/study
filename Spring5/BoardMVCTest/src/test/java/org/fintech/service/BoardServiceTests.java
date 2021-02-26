package org.fintech.service;

import org.fintech.domain.BoardVO;
import org.fintech.domain.Criteria;
import org.junit.Ignore;
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
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	
	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	
	@Ignore
	public void testGet() {
		log.info(service.get(21L));
	}
	
	@Ignore
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		
		board.setTitle("애플리케이션테스트관리0112V2");
		board.setContent("테스트관리 평가V2");
		board.setWriter("김동민");
		
		int result = service.register(board);
		log.info("register success? " + result);
		
	}	
	

}