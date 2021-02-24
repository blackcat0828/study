package org.fintech.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.fintech.domain.Criteria;
import org.fintech.domain.ReplyVO;

public interface ReplyMapper {

	//댓글등록 처리
	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long bno);
	
	//특정 댓글 수정
	public int update(ReplyVO reply);
	
	//특정 댓글 삭제
	public int delete(Long rno);
	
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);
}
