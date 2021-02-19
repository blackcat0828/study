package org.fintech.controller;

import org.fintech.domain.BoardVO;
import org.fintech.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	BoardService service;
	
	//게시판 리스트
	@GetMapping("/list")
	public String List(Model model) {
		log.info("테스트");
		model.addAttribute("list", service.getList());
		return "/board/list";
		
}
	
	//게시판 등록처리를 위한 처리
	@GetMapping("/register")
	public String register() {
		return "/board/register";
	}
	
	
	//RedirectAttributes?
	//해더에 매개변수를 붙이지 않기 위해서 단한번 사용하고 소멸되는 속성을 지정할 때 사용된다.
	//모든 flashAttribute는 다른 url로 redirect하기 전에 session에 해당 자료를 복사해 두었다가
	//다른 url로 redirect한후 session에 복사해둔 flashAttribute속성을 Model객체로 넘긴다. 
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("게시판 신규 등록" + board);
		service.register(board);
		//insert 한후 게시판 번호를 가져온다.
		//addFlashAttribute()는 단한번 사용후 소멸
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	//특정 게시판 상세 보기
	@GetMapping("/get")
	public String get(@RequestParam("bno") Long bno, Model model) {
		model.addAttribute("board",service.get(bno));
		return "board/get";
		
	}
	
	@GetMapping("/modifyForm")
	public String modifyForm(@RequestParam("bno") Long bno, Model model) {
		model.addAttribute("board",service.get(bno));
		return "board/modify";
		
	}
	//게시판 수정
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("게시판 수정:" + board);
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	//게시판 삭제
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("삭제 게시판 번호: " + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}

		return "redirect:/board/list";
	}
}
