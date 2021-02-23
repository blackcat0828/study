package org.fintech.domain;

import lombok.Data;

//화면 페이징 처리를 위한 클래스
@Data
public class PageDTO {

	private int startPage;//시작페이지
	private int endPage;//마지막페이지
	private boolean prev;//이전페이지 체크
	private boolean next;//다음페이지 체크
	
	private int total;//전체 게시판 데이터수
	private Criteria cri;//페이징처리
	
	public PageDTO(Criteria cri,int total) {
		this.cri = cri;
		this.total = total;
		
		//각 페이지의 하단 페이징처리 마지막 페이지번호
		//cri.getPageNum() => 하단의 페이지 번호
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage = this.endPage - 9;
		
		//실제 필요한 페이지수
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		//this.startPage > 1 이부분은
		//데이터갯수가 2페이지 이상이므로 이전페이지가 존재하므로
		//prev 에 true 대입
		this.prev = this.startPage > 1;
		//하단의 페이징 페이지 번호가 최대 페이지수보다 작다라는 이야기는
		//다음페이지가 존재한다는 의미이므로 true 대입
		this.next = this.endPage < realEnd;
		
	}
	
	
}








