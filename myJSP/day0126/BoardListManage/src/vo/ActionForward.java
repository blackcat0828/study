package vo;

//클라이언트의 요청을 최종적으로 View jsp 페이지에 보여주기 위한 설정으로
//dispatcher 방식(forward 방식과 include 방식)과 redirect 방식으로 수행가능
public class ActionForward {
	
	private String path;
	private boolean redirect;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	
}
