package board.board.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.board.entity.BoardEntity;
import board.board.entity.BoardFileEntity;

public interface JpaBoardService {

	List<BoardEntity> selectBoardList() throws Exception;
	
	void saveBoard(BoardEntity board,MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
	
	void updateBoard(BoardEntity board) throws Exception;

	BoardEntity selectBoardDetail(int boardIdx) throws Exception;
	
	void deleteBoard(int boardIdx);
	
	BoardFileEntity selectBoardFileInformation(int boardIdx,int idx) throws Exception;
	
	//페이징처리 게시물 목록 가져오기 03.17
	Page<BoardEntity> getBoardList(Pageable pageable);
	
}



