package org.fintech.service;

import java.util.List;

import org.fintech.domain.BoardVO;
import org.fintech.domain.Criteria;

public interface BoardService {

	//게시판 신규 등록
	public void register(BoardVO board);
	
	//특정 게시판 상세보기
	public BoardVO get(Long bno);
	
	//특정 게시판 수정
	public boolean modify(BoardVO board);
	
	//특정 게시판 삭제
	public boolean remove(Long bno);
	
	//게시판 리스트
	public List<BoardVO> getList();
	
	//페이징 처리 02.22
	public List<BoardVO> getList(Criteria cri);
	
	//전체 게시물 갯수 구하기 02.22
	public int getTotal(Criteria cri);
	
	
	
}



