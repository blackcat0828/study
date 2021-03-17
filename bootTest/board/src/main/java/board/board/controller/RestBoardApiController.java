package board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import board.board.dto.BoardDto;
import board.board.service.BoardService;

//@Controller + @RequestBody
//@RestController 사용하면 API 결과값을 Response Body 를 사용하여
//보내주며 서버와 클라이언트 통신사이에 데이터는 JSON형태를 사용한다.
@RestController
public class RestBoardApiController {

	@Autowired //자동 DI
	private BoardService boardService;
	
	//전체 게시물 목록 가져오기
	@RequestMapping(value="/api/board",method=RequestMethod.GET)
	public List<BoardDto> openBoardList() throws Exception {
		return boardService.selectBoardList();
	}
	
	//신규 게시물 등록처리
	//@RequestBody ?
	//@RequestMapping에 의해 post방식으로 전송된 Http 요청 데이터를 
	//BoardDto 형태로 바인딩 처리를 해준다.
	@RequestMapping(value="/api/board/write",method=RequestMethod.POST)
	public void insertBoard(@RequestBody BoardDto board) throws Exception {
		boardService.insertBoard(board, null);
	}
	
	//특정 게시물 상세보기 처리
	@RequestMapping(value="/api/board/{boardIdx}",method=RequestMethod.GET)
	public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
		return boardService.selectBoardDetail(boardIdx);
	}
	
	//특정 게시물 수정처리
	@RequestMapping(value="/api/board/{boardIdx}",method=RequestMethod.PUT)
	public String updateBoard(@RequestBody BoardDto board) throws Exception {
		boardService.updateBoard(board);
		
		//게시물 목록으로 이동
		return "redirect:/board";
	}
	
	//특정 게시물 삭제 처리
	@RequestMapping(value="/api/board/{boardIdx}",method=RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
		boardService.deleteBoard(boardIdx);
		
		return "redirect:/board";
	}
}






