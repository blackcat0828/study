package board.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import board.board.dto.BoardDto;
import board.board.dto.BoardFileDto;
import board.board.service.BoardService;

@Controller
public class RestBoardController {

	@Autowired
	private BoardService boardService;

	//게시물 목록 가져오기
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public ModelAndView openBoardList() throws Exception {

		ModelAndView mv = new ModelAndView("/board/restBoardList");
		List<BoardDto> list = boardService.selectBoardList();

		mv.addObject("list", list);

		return mv;
	}

	//신규 게시물 등록을 위한 화면 폼 처리
	@RequestMapping(value = "/board/write", 
			        method = RequestMethod.GET)
	public String openBoardWrite() throws Exception {
		//templates > board > restBoardWrite.html
		return "/board/restBoardWrite";
	}

	//신규 게시물 등록처리 
	@RequestMapping(value = "/board/write", 
			        method = RequestMethod.POST)
	public String openBoardWrite(BoardDto board, 
			                     MultipartHttpServletRequest multipartHttpServletRequest)
			throws Exception {

		//신규 게시물 등록처리
		boardService.insertBoard(board, multipartHttpServletRequest);
		
		//게시물 목록 url로 이동
		return "redirect:/board";
	}

	//특정 게시물 상세보기
	@RequestMapping(value = "/board/{boardIdx}", 
			        method = RequestMethod.GET)
	public ModelAndView openBoardDetail(
			//url에 있는 매개변수 boardIdx 값을 가져온다.
			@PathVariable("boardIdx") int boardIdx) throws Exception {

		//게시물 상세보기 url 지정
		ModelAndView mv = new ModelAndView("/board/restBoardDetail");
		
		//특정 게시물 내역을 가져와서 board 참조변수에 대입
		BoardDto board = boardService.selectBoardDetail(boardIdx);

		//Model 객체에 board라는 속성을 지정
		mv.addObject("board", board);

		return mv;
	}

	//특정 게시물 수정처리
	@RequestMapping(value = "/board/{boardIdx}", 
			        method = RequestMethod.PUT)
	public String updateBoard(BoardDto board) throws Exception {
		boardService.updateBoard(board);

		return "redirect:/board";
	}

	//특정 게시물 삭제처리
	@RequestMapping(value = "/board/{boardIdx}", 
			        method = RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
		boardService.deleteBoard(boardIdx);

		return "redirect:/board";
	}

	//첨부파일 다운로드 처리
	@RequestMapping(value = "/board/file", 
			        method = RequestMethod.GET)
	public void downloadBoardFile(@RequestParam int idx, 
								  @RequestParam int boardIdx, 
								  HttpServletResponse response) throws Exception {

		BoardFileDto boardFile = 
			boardService.selectBoardFileInformation(idx, boardIdx);

		if (ObjectUtils.isEmpty(boardFile) == false) {

			// 업로드한 파일의 원본이름
			String fileName = boardFile.getOriginalFileName();

			// 실제로 서버에 저장되어 있는 파일을 읽어서 byte배열에 저장
			byte[] files = FileUtils.readFileToByteArray(
					new File(boardFile.getStoredFilePath()));

			// 응답처리시 MIME 형식 지정
			response.setContentType("application/octet-stream");
			// 응답처리시 파일크기
			response.setContentLength(files.length);
			// Content-Disposition : attachment => 파일을 다운로드
			// Content-Disposition : inline => 파일을 웹브라우저에 출력
			// "Content-Disposition","attachment; fileName=
			response.setHeader("Content-Disposition",
					"attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");

			// 클라이언트에게 데이터를 전송시 데이터의 Body를 인코딩한 방식을 선언
			response.setHeader("Content-Transfer-Encoding", "binary");

			// 읽어온 파일정보를 바이트 배열의 데이터를 response에 저장
			response.getOutputStream().write(files);
			// response 버퍼를 강제로 비운다.
			response.getOutputStream().flush();
			// reponse close
			response.getOutputStream().close();
		}
	}
}
