package org.fintech.controller;

import java.util.List;

import org.fintech.domain.Criteria;
import org.fintech.domain.ReplyVO;
import org.fintech.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies")
@Log4j
@AllArgsConstructor
public class ReplyController {
	private ReplyService service;
	
	//댓글 신규 등록 처리
	@PostMapping(value="/new", consumes = "application/json",
								produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		int insertCount = service.register(vo);
		log.info("신규 댓글 등록 건수: " + insertCount);
		
		//ResponseEntity?
		//데이터 뿐만 아니라 응답 처리 코드까지 설정 가능
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) :
									new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//댓글 수정 처리
	//수정 전송방식
	//1. PUT : 객체 전체 데이터를 수정하고자 할때 사용
	//2. PATCH : PUT과 같은 수정모드이나 객체 전체가 아니라 일부분을 수정시 사용
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH}, value="/{rno}",
				consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno){
		vo.setRno(rno);
		
		return service.modify(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK) :
										new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value="/{rno}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		
		return service.remove(rno) == 1 ? new ResponseEntity<>("success", HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//특정 댓글 상세보기
	@GetMapping(value="/{rno}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		return new ResponseEntity<>(service.get(rno),HttpStatus.OK);
	}
	
	//특정 게시글의 댓글 리스트
	@GetMapping(value="/pages/{bno}/{page}",
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE}
			)
	public ResponseEntity<List<ReplyVO>> getList(
				@PathVariable("page") int page,
				@PathVariable("bno") Long bno){
		Criteria cri = new Criteria(page, 10);
		
		return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
	}
	
	
}