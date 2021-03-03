package org.fintech.controller;

import java.util.List;
import java.util.stream.IntStream;

import org.fintech.domain.Criteria;
import org.fintech.domain.ReplyVO;
import org.fintech.mapper.ReplyMapper;
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
public class ReplyMapperTests {
	
	//댓글처리를 위한 게시물번호를 Long 타입의 배열로 지정
	private Long[] bnoArr = {483L,484L,485L};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;//인터페이스를 DI(의존적 주입)
	
	@Ignore
	public void testCreate() {
		
		//rangeClosed(1,10) : 1 ~ 10 동작
		IntStream.rangeClosed(1,10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
			//bnoArr[2]
			vo.setBno(bnoArr[i%3]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("댓글 작성자" + i);
			
			mapper.insert(vo);
		});
	}
	
	@Ignore
	public void testRead() {
		
		Long rno = 7L;
		
		ReplyVO vo = mapper.read(rno);
		log.info(vo);
		
	}
	
	//특정 댓글 수정하기
	@Ignore
	public void testUpdate() {
		
		Long rno = 7L;//7번 댓글
		
		//댓글 수정을 하기위해 특정댓글 내역 가져오기
		ReplyVO vo = mapper.read(rno);
		
		//댓글내용 수정
		vo.setReply("댓글을 수정02.24");
		
		int count = mapper.update(vo);
		log.info("수정건수:" + count);
		
	}
	
	/* 특정 댓글 삭제 */
	@Ignore
	public void testDelete() {
		
		Long rno = 7L;
		
		int count = mapper.delete(rno);
		log.info("삭제건수:" + count);
	}
	
	//댓글 목록 자져오기
	@Ignore
	public void testList() {
		
		Criteria cri = new Criteria();
		long bno = 484L;		
		
		//특정 게시물에 대한 댓글 목록을 가져온다.
		List<ReplyVO> replies = mapper.getListWithPaging(cri,bno);
		
		replies.forEach(reply -> log.info(reply));
		
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(1,10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 42L);
		replies.forEach(reply -> log.info(reply));
		
	}

}