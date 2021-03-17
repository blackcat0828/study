package board.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import board.board.entity.BoardEntity;
import board.board.entity.BoardFileEntity;
import board.board.service.JpaBoardService;

@Controller
public class JpaBoardController {

	@Autowired
	private JpaBoardService jpaBoardService;
	
	//게시물 리스트 가져오기
	@RequestMapping(value="/jpa/board",method=RequestMethod.GET)
	public ModelAndView openBoardList(ModelMap model) throws Exception {
		
		ModelAndView mv = new ModelAndView("/jpa/board/Paging");
		
		List<BoardEntity> list = jpaBoardService.selectBoardList();
		
		mv.addObject("list", list);
		
		return mv;
	}
	
	//신규 게시물 등록 화면 실행
	@RequestMapping(value="/jpa/board/write",method=RequestMethod.GET)
	public String openBoardWrite() throws Exception {
		return "/board/jpaBoardWrite";
	}
	
	//게시판 등록화면에서 등록버튼 클릭 처리 
	@RequestMapping(value="/jpa/board/write",method=RequestMethod.POST)
	public String writeBoard(BoardEntity board,MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		jpaBoardService.saveBoard(board,multipartHttpServletRequest);
		
		return "redirect:/jpa/board/Paging";
	}
	
	//특정 게시물 상세보기
	@RequestMapping(value="/jpa/board/{boardIdx}",
			        method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
		
		ModelAndView mv = new ModelAndView("/board/jpaBoardDetail");
		
		BoardEntity board = jpaBoardService.selectBoardDetail(boardIdx);
		
		mv.addObject("board",board);
		
		return mv;
	}
	
	//특정게시물 수정처리
	@RequestMapping(value="/jpa/board/{boardIdx}",
			        method=RequestMethod.PUT)
	public String updateBoard(BoardEntity board) throws Exception {
		jpaBoardService.updateBoard(board);
		
		return "redirect:/jpa/board/Paging";
	}
	
	//특정 게시물 삭제처리
	@RequestMapping(value="/jpa/board/{boardIdx}",
			        method=RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
		jpaBoardService.deleteBoard(boardIdx);
		
		return "redirect:/jpa/board/Paging";
	}
	
	//첨부파일 다운로드 처리
	@RequestMapping(value="/jpa/board/file",method=RequestMethod.GET)
	public void downloadBoardFile(int boardIdx,int idx,HttpServletResponse response) throws Exception {
		
		//특정 게시물의 특정 첨부파일 내역을 가져와서 file 참조변수에 대입
		BoardFileEntity file = 
			jpaBoardService.selectBoardFileInformation(boardIdx,idx);
		
		byte[] files = FileUtils.readFileToByteArray(new File(file.getStoredFilePath()));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(files.length);
		response.setHeader("Content-Disposition","attachment; fileName=\"" + URLEncoder.encode(file.getOriginalFileName(),"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding","binary");
		
		response.getOutputStream().write(files);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	//페이징 처리 03.17
	@RequestMapping(value="/jpa/board/Paging",
			        method=RequestMethod.GET)
	//@PageableDefault ?
	//페이징처리를 하는 어노테이션으로 페이지수,총자료수,정렬등을 기본적으로
	//제공하는 것으로 만약 값을 지정하지 않으면 자동으로 초기값을 부여한다.
	//Pageable?
	//JPA 에서 페이징처리를 쉽게처리
	//매 쿼리 실행시마다 SQL을 수행하여 페이지수,총자료수,정렬등을 갱신한다.
	public String boardPagingView(
			@PageableDefault Pageable pageable,Model model) {
		
		Page<BoardEntity> boardList = 
				         jpaBoardService.getBoardList(pageable);
		
		//페이징처리된 게시물 목록을 boardList 속성에 대입
		model.addAttribute("boardList",boardList);
		
		return "/board/jpaBoardWithPaging";
		
	}
	
	
	
	
	
}





