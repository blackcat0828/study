package org.fintech.service;

import java.util.List;

import org.fintech.domain.BoardVO;

public interface BoardService {
	//게시판 신규 등록
	public void register(BoardVO board);
	
	//특정 게시판 상세 보기
	public BoardVO get(Long bno);
	
	//특정 게시판 수정
	public boolean modify(BoardVO baord);
	
	//특정 게시판 삭제
	public boolean remove(Long bno);
	
	//게시판 리스트
	public List<BoardVO> getList();
}
