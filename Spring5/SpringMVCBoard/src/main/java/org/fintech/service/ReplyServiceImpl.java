package org.fintech.service;

import java.util.List;

import org.fintech.domain.Criteria;
import org.fintech.domain.ReplyVO;
import org.fintech.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	//특정 댓글 상세보기
	@Override
	public ReplyVO get(Long rno) {
		return mapper.read(rno);
	}
	
	//특정 댓글 수정
	@Override
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}
	
	//댓글 신규 등록 처리
	@Override
	public int register(ReplyVO vo) {
		
		return mapper.insert(vo);
	}
	
	
	//특정 댓글 삭제 처리
	@Override
	public int remove(Long rno) {
		return mapper.delete(rno);
	}
	
	
	//댓글 목록
	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		return mapper.getListWithPaging(cri, bno);
	}
}
