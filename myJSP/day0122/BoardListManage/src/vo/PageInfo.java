package vo;

public class PageInfo {

	private int page;//현재 페이지
	private int maxPage;//게시물을 보여주기 위한 최대 페이지수
	private int startPage;//해당페이지의 시작페이지
	private int endPage;//해당페이지의 종료페이지
	private int listCount;//게시물의 총건수
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
}
