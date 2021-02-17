package org.fintech.service;

import java.util.List;

import org.fintech.domain.BoardVO;
import org.fintech.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
//모든 멤버변수를 매개변수로 하는 생성자를 생성
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
  private BoardMapper mapper;
  
  @Override
	public List<BoardVO> getList() {
	  	
	  	return mapper.getList();
	}
  
  @Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}
  
  @Override
	public boolean remove(Long bno) {
		return mapper.delete(bno) == 1;
	}
  
  @Override
	public boolean modify(BoardVO baord) {
		return mapper.update(baord) == 1;
	}
  
  
  @Override
	public void register(BoardVO board) {
	  mapper.insertSelectKey(board);
	}
	
	
}
