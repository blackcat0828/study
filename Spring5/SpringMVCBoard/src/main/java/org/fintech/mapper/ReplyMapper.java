package org.fintech.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.fintech.domain.Criteria;
import org.fintech.domain.ReplyVO;

public interface ReplyMapper {
	
	//댓글등록 처리
	public int insert(ReplyVO vo);
	
	//특정댓글 상세보기
	public ReplyVO read(Long rno);
	
	//특정댓글 수정
	public int update(ReplyVO reply);
	
	//특정댓글 삭제
	public int delete(Long rno);
	
	//댓글 페이징 처리
	//url에 있는 Criteria와 Bno 매개변수 값을 가져와 cri,bno 변수에 대입
	public List<ReplyVO> getListWithPaging(
				@Param("cri") Criteria cri,
				@Param("bno") Long bno);
	
	//게시물에 대한 댓글 갯수 구하기 03.03
	public int getCountByBno(Long bno);
}




