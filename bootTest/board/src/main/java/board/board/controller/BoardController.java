package board.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import board.board.dto.BoardDto;
import board.board.dto.BoardFileDto;
import board.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {

	// LogBack 설정 03.10
	// this.getClass() : 현재 클래스명을 로깅의 매개변수로 보낸다.
	// private Logger log = LoggerFactory.getLogger(this.getClass());

	// BoardService 클래스를 자동으로 의존적주입(Dependency Injection)
	@Autowired
	private BoardService boardService;

	// 실행 URL을 지정
	// http://localhost:8080/board/openBoardList.do
	// 게시판 목록 가져오기
	// ModelAndView ?
	// Model(JSP등에게 보낼 데이터를 담고 있는 객체) + View 지정
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception {

		log.debug("openBoardList()");

		// ModelAndView 인스턴스 생성
		ModelAndView mv = new ModelAndView();
		// 실행하려는 url 지정
		mv.setViewName("/board/boardList");

		// BoardService.java 의 selectBoardList()를 실행하여
		// 게시판 목록을 list 참조변수에 대입
		List<BoardDto> list = boardService.selectBoardList();
		// model에 속성을 지정
		mv.addObject("list", list);

		return mv;
	}

	// 신규 게시물 등록 폼 불러오기 03.09
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception {
		// board 폴더밑에 있는 boardWrite.html 을 호출한다.
		return "/board/boardWrite";
	}

	//신규 게시물 등록 화면에서 등록버튼 클릭 처리 03.09
	//파일 업로드를 위해 MultipartHttpServletRequest 클래스를
	//매개변수로 추가 03.12
	//MultipartHttpServletRequest ?
	//ServletRequest를 상속받아 구현된 인터페이스로 업로드된 파일처리를
	//위한 메서드를 제공해준다.
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board,MultipartHttpServletRequest  multipartHttpServletRequest) throws Exception {
		boardService.insertBoard(board,multipartHttpServletRequest);

		return "redirect:/board/openBoardList.do";

	}

	// 특정 게시물 상세보기 처리 03.10
	// @RequestParam : url에 있는 매개변수의 값을 가져오는 어노테이션
	// 게시물 리스트에서 클릭한 게시물 번호를 가져온다.
	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {

		// model 객체를 이용해 데이터를 html에서 출력하도록 보관하고
		// View를 지정하는 객체
		ModelAndView mv = new ModelAndView("/board/boardDetail");

		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);

		return mv;
	}

	// 특정 게시물 수정처리 03.10
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardDto board) throws Exception {
		boardService.updateBoard(board);
		// 게시물 목록으로 이동
		return "redirect:/board/openBoardList.do";
	}

	// 특정 게시물 삭제(03.10)
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(int boardIdx) throws Exception {
		boardService.deleteBoard(boardIdx);
		// 게시물 목록으로 이동
		return "redirect:/board/openBoardList.do";
	}
	
	//특정 게시물의 특정 첨부파일 다운로드 처리 03.15
	@RequestMapping("/board/downloadBoardFile.do")
	public void downloadBoardFile(
						//url상의 매개변수 값을 가져와서 변수에 대입
						@RequestParam int idx,
						@RequestParam int boardIdx,
	//HttpServletResponse?
    //서버가 클라이언트에게 전달할 데이터를 가지고 있는 클래스
	//HttpServletRequest ?
	//클라이언트에서 서버로 오는 모든 요청정보를 가지고 있는 클래스					
						HttpServletResponse response) throws Exception {
		
		//다운로드 할려는 특정 첨부파일 내역을 가져와서 BoardFileDto 형태의
		//boardFile 참조변수에 대입한다.
		BoardFileDto boardFile 
		   = boardService.selectBoardFileInformation(idx,boardIdx);
		//리턴한 첨부파일 내역이 존재하면
		if(ObjectUtils.isEmpty(boardFile) == false) {
			
			//업로드한 파일의 원본이름
			String fileName = boardFile.getOriginalFileName();
			
			//실제로 서버에 저장되어 있는 파일을 읽어서 byte배열에 저장
			byte[] files  = FileUtils.readFileToByteArray(
			    		new File(boardFile.getStoredFilePath()));
			
			//응답처리시 MIME 형식 지정
			response.setContentType("application/octet-stream");
			//응답처리시 파일크기
			response.setContentLength(files.length);
			//Content-Disposition : attachment => 파일을 다운로드
			//Content-Disposition : inline => 파일을 웹브라우저에 출력
			//"Content-Disposition","attachment; fileName=
			response.setHeader(
					"Content-Disposition","attachment; fileName=\"" +
			        URLEncoder.encode(fileName,"UTF-8")+"\";");
			
			//클라이언트에게 데이터를 전송시 데이터의 Body를 인코딩한 방식을 선언
			response.setHeader("Content-Transfer-Encoding","binary");
			
			//읽어온 파일정보를 바이트 배열의 데이터를 response에 저장
			response.getOutputStream().write(files);
			//response 버퍼를 강제로 비운다.
			response.getOutputStream().flush();
			//reponse close
			response.getOutputStream().close();
			
		}
		
		
		
	}
	
	
	
	
	

}



