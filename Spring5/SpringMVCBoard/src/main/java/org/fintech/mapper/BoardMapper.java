package org.fintech.mapper;

import java.util.List;

import org.fintech.domain.BoardVO;
import org.fintech.domain.Criteria;

public interface BoardMapper {

	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	//insert만 하는 경우
	public void insert(BoardVO board);
	
	//insert후 pk값을 리턴받으려는 경우
	public void insertSelectKey(BoardVO board);
	
	//게시판 상세보기
	public BoardVO read(Long bno);
	
	//게시판 삭제처리
	public int delete(Long bno);
	
	//게시판 수정처리
	public int update(BoardVO board);
	
	//페이징 처리 02.22
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	//전체 데이터수 가져오기 02.22
	public int getTotalCount(Criteria cri);
	
	
}




