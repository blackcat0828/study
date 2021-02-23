package org.fintech.service;

import java.util.List;

import org.fintech.domain.BoardVO;
import org.fintech.domain.Criteria;
import org.fintech.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
//모든 멤버변수를 매개변수로 하는 생성자를 생성
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);		
	}

	//특정 게시판 상세보기
	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	//페이징 처리 02.22
	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	//전체 게시물 갯수 구하기 02.22
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

}





