package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardReplyProService;
import vo.ActionForward;
import vo.BoardBean;

//특정 게시판에 대한 댓글등록 처리
public class BoardReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		//현재페이지 가져온다.
		String nowPage = request.getParameter("page");
		
		//댓글등록을 위해 인스턴스 생성
		BoardBean article = new BoardBean();
		
		article.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		article.setBoard_name(request.getParameter("board_name"));
		article.setBoard_pass(request.getParameter("board_pass"));
		article.setBoard_subject(request.getParameter("board_subject"));
		article.setBoard_content(request.getParameter("board_content"));
		//댓글번호
		article.setBoard_re_ref(Integer.parseInt(request.getParameter("board_re_ref")));
		//댓글레벨
		article.setBoard_re_lev(Integer.parseInt(request.getParameter("board_re_lev")));
		//댓글레벨의 일련번호
		article.setBoard_re_seq(Integer.parseInt(request.getParameter("board_re_seq")));
		
		BoardReplyProService boardReplyProService 
		       = new BoardReplyProService();
		
		//replyArticle 메서드에서 댓글 등록 처리
		boolean isReplySuccess = 
				boardReplyProService.replyArticle(article);
		
		//댓글처리가 성공이면
		//게시판리스트로 이동하되 작업중인 페이지로 이동한다.
		if(isReplySuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo?page=" + nowPage);
		}else {//댓글등록이 실패
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('댓글등록 처리 실패하였습니다.')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;	
	
	}
	
}