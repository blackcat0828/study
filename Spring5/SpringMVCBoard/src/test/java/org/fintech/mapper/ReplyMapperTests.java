package org.fintech.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.fintech.domain.Criteria;
import org.fintech.domain.ReplyVO;
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
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		)
@Log4j
public class ReplyMapperTests {
	private Long[] bnoArr = {41L, 42L, 43L};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper; //인터페이스를 DI(의존적 주입)
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i%3]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("댓글 작성자" + i);
			
			mapper.insert(vo);
		});
	}
	
	@Ignore
	public void testRead() {
		ReplyVO reply = mapper.read(42L);
		log.info(reply);
	}
	
	@Ignore
	public void testUpdate() {
		ReplyVO reply = new ReplyVO();
		
		reply.setReply("업데이트 테스트1");
		reply.setReplyer("업데이트 작성자1");
		reply.setRno(2L);
		
		int count = mapper.update(reply);
		log.info("수정건수:" + count);
	}
	
	@Ignore
	public void testDelete() {
		log.info("삭제건수:" + mapper.delete(7L));
	}
	
	@Ignore
	public void testList() {
		Criteria cri = new Criteria();
		long bno = 43L;
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bno);
		replies.forEach(reply -> log.info(reply));
	}
	
	
}
