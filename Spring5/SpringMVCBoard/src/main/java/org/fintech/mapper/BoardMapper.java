package org.fintech.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.fintech.domain.BoardVO;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	//insert만 하는 경우
	public void insert(BoardVO board);
	
	//insert후 pk값을 리턴받을 경우
	public void insertSelectKey(BoardVO board);
	public BoardVO read(long bno);
	
	public int delete(long bno);
	
	public int update(BoardVO board);
}
