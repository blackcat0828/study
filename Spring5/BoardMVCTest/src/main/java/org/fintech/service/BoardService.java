package org.fintech.service;

import java.util.List;

import org.fintech.domain.BoardVO;
import org.fintech.domain.Criteria;

public interface BoardService {

	//게시물 등록
	public int register(BoardVO board);
	
	//특정 게시물 상세보기
	public BoardVO get(Long bno);
	
	//게시물 수정
	public boolean modify(BoardVO board);
	
	//게시물 삭제
	public boolean remove(Long bno);
	
	//게시판 전체조회
	//public List<BoardVO> getList();
	
	//게시판 페이징 처리 
	public List<BoardVO> getList(Criteria cri);
	public List<BoardVO> getList();
	
	//조회시 전체 데이터 건수 
	public int getTotal(Criteria cri);
	
}
