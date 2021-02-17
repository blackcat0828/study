package org.fintech.service;

import static org.junit.Assert.assertNotNull;

import org.fintech.domain.BoardVO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Ignore
	public void testExist() {
		log.info(service);
		//BoardService가 Null인지 여부 체크
		assertNotNull(service);
	}
	
	@Ignore
	public void testRegister() {
		BoardVO board = new BoardVO();
		
		board.setTitle("자바 교육");
		board.setContents("상속과 추상클래스 교육");
		board.setWriter("이순신");
		
		service.register(board);
		
		log.info("생성된 게시판 번호: " + board.getBno());
		
	}
	
	//게시판 리스트 가져오기
	@Ignore
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	@Ignore
	public void testGet() {
		log.info(service.get(2L));
	}
	
	@Test
	public void testModify() {
		BoardVO board = new BoardVO();
		board.setBno(2L);
		board.setContents("모디파이 테스트");
		board.setTitle("모디파이 테스트 타이틀");
		board.setWriter("김동민");
		log.info(service.modify(board));
	}
	
	@Ignore
	public void testRemove() {
		log.info(service.remove(4L));
	}
	
}
