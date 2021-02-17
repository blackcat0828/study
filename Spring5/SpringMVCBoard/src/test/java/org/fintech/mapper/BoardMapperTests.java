package org.fintech.mapper;

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
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Ignore
	public void testGetList() {
		//람다식 표현
		//board 변수
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Ignore
	public void testInsert() {
		BoardVO board = new BoardVO();
		
		board.setTitle("테스트123132 교육");
		board.setContents("Mapper교육실시");
		board.setWriter("홍길동");
		
		mapper.insert(board);
		
		log.info(board);
		
	}
	
	@Test
	public void testSelectKey() {
		BoardVO board = new BoardVO();
		
		board.setTitle("JSP12312312312 교육");
		board.setContents("JSP 교육실시");
		board.setWriter("김동민");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
		
	}
	
	@Ignore
	public void testRead() {
		BoardVO board = mapper.read(22L);
		
		log.info(board);
	}
	
	@Ignore
	public void testDelete() {
		int result = mapper.delete(22L);
		
		log.info(result);
	}
	
	@Ignore
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(6L);
		board.setTitle("업데이트 타이틀");
		board.setContents("업데이트 콘텐츠");
		board.setWriter("김동민2");
		int result = mapper.update(board);
		log.info(board);
		
	}
	
}
