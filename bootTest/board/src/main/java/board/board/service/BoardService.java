package board.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.board.dto.BoardDto;
import board.board.dto.BoardFileDto;

public interface BoardService {

	//게시판 목록 가져오기 03.09
	List<BoardDto> selectBoardList() throws Exception;
	
	//신규 게시물 등록 03.09
	//파일 업로드를 위해 MultipartHttpServletRequest 추가 03.12
	void insertBoard(BoardDto board,MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
	
	//특정 게시물 상세보기 03.10
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	//특정 게시물 수정처리 03.10
	void updateBoard(BoardDto board) throws Exception;
	
	//특정 게시물 삭제처리 03.10
	void deleteBoard(int boardIdx) throws Exception;
	
	//특정 게시물의 특정 첨부파일 목록 가져오기 03.15
	BoardFileDto selectBoardFileInformation(int idx,int boardIdx) throws Exception;
	
	
}






