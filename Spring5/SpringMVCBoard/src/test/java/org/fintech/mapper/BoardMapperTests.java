package org.fintech.mapper;

import java.util.List;

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
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Ignore
	public void testGetList() {
		//람다식 표현
		//board : 변수
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Ignore
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		
		board.setTitle("자바 교육");
		board.setContent("자바교육실시");
		board.setWriter("강감찬");

		mapper.insert(board);
		
		log.info(board);
		
	}
	
	
	@Ignore
	public void testSelectKey() {
		
		BoardVO board = new BoardVO();
		
		board.setTitle("JSP 교육");
		board.setContent("JSP 교육실시");
		board.setWriter("이순신");

		mapper.insertSelectKey(board);
		
		log.info(board);
		
	}
	
	@Ignore
	public void testRead() {
		BoardVO board = mapper.read(7L);
		log.info(board);
	}
	
	@Ignore
	public void testDelete() {
		log.info("삭제건수:" + mapper.delete(4L));
	}
	
	@Ignore
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		
		board.setBno(7L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("신사임당");
		
		int count = mapper.update(board);
		log.info("수정건수:" + count);
		
		
	}
	
	//페이징 처리 테스트 02.22
	@Ignore
	public void testPaging() {
		
		Criteria cri = new Criteria();
		
		//페이지당 10개의 데이터를 리턴한다.
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		//람다식을 이용해 가져온 10개의 데이터를 콘솔에 출력
		//board => 변수
		list.forEach(board -> log.info(board));
		
	}
	
	//OGNL 테스트 02.22
	@Test
	public void testSearch() {
		
		Criteria cri = new Criteria();
		
		cri.setType("TC");//검색조건이 타이틀 + 내용
		cri.setKeyword("백신");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
		
		
	}
	
	
	
	
	
}











