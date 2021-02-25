package org.fintech.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.fintech.domain.SampleVO;
import org.fintech.domain.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	
	//produces?
	//클라이언트가 서버에 요청하는 헤더 정보의 MediaType와 같은 경우에만 클라이언트에게 응답처리를 해준다는 의미
	
	//consumes ?
	//consumes=MediaType.APPLICATION_JSON_VALUE(application/json)
	//클라이언트의 요청중 JSON 형태의 데이터만 가지고 있는 클라이언트 요청만 처리하겠다는 선언
	@GetMapping(value="/getText", produces="text/plain;charset=UTF-8")
	public String getText() {
		
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	//http://localhost:8080/sample/getSample
	@GetMapping(value="/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	@GetMapping(value="/getList", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<SampleVO> getList(){
		//stream(스트림)
		//스트림 선언 + 중간 연산처리 + 최종 연산처리
		//IntStream : 정수형 스트림 사용을 선언
		//중간연산처리 : 정렬(내림차순, 오름차순), Filter(필터)
		//최종 연산처리 : sum(), count() 등등
		//range(1,10) : 1~9
		//mapToObj : 기본형 자료를 객체 스트림으로 변환
		//collect : 결과를 담는 리스트를 반환
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i+"First", i+"Last")).collect(Collectors.toList());
	}
	
	@GetMapping(value="/getMap", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111,"그루트","주니어"));
		return map;
	}
	
	
	//params : 매개변수 지정
	//ResponseEntity ?
	//REST 방식은 화면자체를 호출하는 게 아니라 데이터 자체를 전송하는 방식으로
	//ResponseEntity 를 사용하여 데이터와 함께 Http Header의 상태 메시지도 같이 전달할 때 사용한다.
	@GetMapping(value="/check", params = {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0,""+height,""+weight);
		ResponseEntity<SampleVO> result = null;
		if(height < 150) {
			//status : http 상태코드값
			//HttpStatus.BAD_GATEWAY : 502
			//HttpStatus.OK : 200(정상)
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
		
	}
	
	@GetMapping("/product/{cat}/{pid}")
	//기본 자료형은 안되고 래퍼클래스가 와야한다.
	public String[] getPath(
				@PathVariable("cat") String cat,
				@PathVariable("pid") Integer pid) {
		return new String[] {"category: " + cat, " productId: " + pid};
	}
	
	
	//Controller로 전송된 JSON 형태의 정보가 자동적으로 MAP형태로 변환
	//되어 해당 변수에 저장된다.
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert 메서드 실행"+ticket);
		
		return ticket;
	}
	
}