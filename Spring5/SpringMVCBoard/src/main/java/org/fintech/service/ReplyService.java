package org.fintech.service;

import java.util.List;

import org.fintech.domain.Criteria;
import org.fintech.domain.ReplyVO;

public interface ReplyService {
	//댓글 등록 처리
	public int register(ReplyVO vo);
	
	//특정 댓글 상세보기
	public ReplyVO get(Long rno);
	
	//특정 댓글 수정처리
	public int modify(ReplyVO vo);
	
	//특정 댓글 삭제처리
	public int remove(Long rno);
	
	//댓글 목록 가져오기
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	
	
}
