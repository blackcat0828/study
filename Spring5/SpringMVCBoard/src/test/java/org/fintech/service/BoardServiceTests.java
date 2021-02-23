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
@ContextConfiguration(
		"file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Ignore
	public void testExist() {
		log.info(service);
		//BoardService 가 null 인지 여부 체크
		assertNotNull(service);
	}
	
	@Ignore
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		
		board.setTitle("자바교육");
		board.setContent("상속과 추상클래스 교육");
		board.setWriter("이순신");
		
		service.register(board);
		
		log.info("생성된 게시판 번호:" + board.getBno());
		
	}
	
	//게시판 리스트 가져오기
	@Ignore
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	@Ignore
	public void testGet() {
		log.info(service.get(8L));
	}
	
	//게시판 수정
	@Ignore
	public void testUpdate() {
		
		BoardVO board = service.get(11L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("제목을 수정합니다.");
		log.info("수정건수:" + service.modify(board));
		
	}
	
	@Test
	public void testDelete() {
		log.info("삭제건수:" + service.remove(11L));
	}
	

}






