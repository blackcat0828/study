package org.fintech.controller;

import org.fintech.domain.BoardVO;
import org.fintech.domain.Criteria;
import org.fintech.domain.PageDTO;
import org.fintech.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	//게시판 리스트
	@GetMapping("/list")
	public void list(Criteria cri,Model model) {
		log.info("/board/list 실행중");
		
		//게시판 리스트를 가져와서 list 라는 model 속성을 지정하면
		//jsp에서 리스트를 출력가능
		model.addAttribute("list",service.getList(cri));
		
		//전체 게시물 갯수 구하기 02.22
		int total = service.getTotal(cri);
		model.addAttribute("pageMaker",new PageDTO(cri,total));
		
	}

	//게시판 등록처리를 위한 처리
	@GetMapping("/register")
	public void register() {
		
	}
	
	//RedirectAttributes ?
	//헤더에 매개변수를 붙이지 않기 위해서 단한번 사용하고 소멸되는 속성을 지정할 때
	//사용된다.
	//모든 flashAttribute는 다른 url로 redirect하기 전에 session에 해당 자료를
	//복사해 두었다가 다른 url로 redirect한후 session에 복사해둔 flashAttribute
	//속성을 Model객체로 넘긴다.
	@PostMapping("/register")
	public String register(BoardVO board,RedirectAttributes rttr) {
		
		log.info("게시판 신규 등록:" + board);
		service.register(board);
		//insert 한후 게시판 번호를 가져온다.
		//addFlashAttribute()는 단한번 사용후 소멸
		rttr.addFlashAttribute("result",board.getBno());
		
		return "redirect:/board/list";
		
	}
	
	//특정 게시판 상세 보기
	//http://localhost:8080/board/get?bno=10
	@GetMapping({"/get","/modify"})
	//@RequestParam : URL에서 bno매개변수의 값을 가져온다.
	public void get(@RequestParam("bno") Long bno,
				    @ModelAttribute("cri") Criteria cri,//02.22
			        Model model) {
		
		log.info("/board/get url 실행");
		
		//특정게시판 정보를 service.get(10L)으로 가져와서
		//board라는 속성에 대입한다.
		model.addAttribute("board",service.get(bno));
		
	}
	
	//게시판 수정
	@PostMapping("/modify")
	public String modify(BoardVO board,
						 @ModelAttribute("cri") Criteria cri,
			             RedirectAttributes rttr) {
		
		log.info("게시판 수정:" + board);
		
		//특정 게시판 수정이 성공하면 true
		//한번 사용하고 소멸하는 속성을 지정
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		
		//페이징처리 관련 속성 지정 02.22
		//rttr.addAttribute("pageNum",cri.getPageNum());//페이지번호
		//rttr.addAttribute("amount",cri.getAmount());//페이지당 보여지는 갯수
		//검색조건 & 키워드 속성 지정 02.23
		//rttr.addAttribute("type",cri.getType());
		//rttr.addAttribute("keyword",cri.getKeyword());
		
		//수정이 완료되면 게시판 리스트로 이동
		//http://localhost:8080/board/list?pageNum=2&amount=10&type=T&keyword=자바
		return "redirect:/board/list" + cri.getListLink();
		
	}
	
	//게시판 삭제
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno,
						 @ModelAttribute("cri") Criteria cri,
			             RedirectAttributes rttr) {
		
		log.info("삭제 게시판 번호:" + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		
		//페이징처리 관련 속성 지정 02.22
		//rttr.addAttribute("pageNum",cri.getPageNum());//페이지번호
		//rttr.addAttribute("amount",cri.getAmount());//페이지당 보여지는 갯수
		//검색조건 & 키워드 속성 지정 02.23
		//rttr.addAttribute("type",cri.getType());
		//rttr.addAttribute("keyword",cri.getKeyword());
		
		
		return "redirect:/board/list" + cri.getListLink();
		
		
	}
	
	
	
	
}







