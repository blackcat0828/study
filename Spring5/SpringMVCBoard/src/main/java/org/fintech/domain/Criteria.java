package org.fintech.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

//페이징 처리

@Data
public class Criteria {

	private int pageNum;//페이지 번호
	private int amount;//한 페이지당 몇개의 데이터를 보여줄건지 선언
	
	//검색기능 관련 선언 02.22
	private String type;//검색조건
	private String keyword;//검색문자열
	
	public Criteria() {//기본생성자=> 멤버변수의 초기화등
		this(1,10);//첫번째 페이지에 10개의 데이터를 보여주도록 선언
	}
	
	public Criteria(int pageNum,int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//검색기능 관련 처리 02.22
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	
	
	public String getListLink() {
	
		//여러개의 매개변수를 연결해서 URL 형태로 생성시켜준다.
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
										.queryParam("pageNum", this.pageNum)
										.queryParam("amount", this.getAmount())
										.queryParam("type", this.getType())
										.queryParam("keyword",this.getKeyword());
		return builder.toUriString();
	}
}





