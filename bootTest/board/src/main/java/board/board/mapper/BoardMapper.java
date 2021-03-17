package board.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import board.board.dto.BoardDto;
import board.board.dto.BoardFileDto;

//해당 인터페이스가 매퍼기능을 수행한다는 선언
@Mapper
public interface BoardMapper {
	
	//게시물 목록을 가져오는 추상 메서드 03.09
	List<BoardDto> selectBoardList() throws Exception;
	
	//신규게시물 등록 처리 03.09
	void insertBoard(BoardDto board) throws Exception;
	
	//게시물 리스트에서 클릭한 게시물 조회수 증가 처리 03.10
	void updateHitCount(int boardIdx) throws Exception;
	
	//특정 게시물 상세보기 03.10
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	//특정 게시물 수정 03.10
	void updateBoard(BoardDto board) throws Exception;
	
	//특정 게시물 삭제 03.10
	void deleteBoard(int boardIdx) throws Exception;
	
	//특정 게시물에 대한 첨부파일 업로드 처리 03.12
	void insertBoardFileList(List<BoardFileDto> list) throws Exception;
	
	//특정 게시물에 대한 첨부파일 목록 가져오기 03.12
	List<BoardFileDto> selectBoardFileList(int boardIdx) throws Exception; 
	
	//특정 게시물에 대한 특정 첨부파일 목록 가져오기 03.15
	//http://localhost:8080/board/downloadBoardFile.do
	//     ?idx=첨부파일일련번호&boardIdx=게시물번호
	//@Param ? 
	//url에 있는 매개변수 값을 가져와서 변수에 대입
	BoardFileDto selectBoardFileInformation(
			@Param("idx") int idx,@Param("boardIdx") int boardIdx);
	
}






