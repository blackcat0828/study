package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

//게시물 수정 처리
public class BoardModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String nowPage = request.getParameter("page");
		ActionForward forward = null;
		boolean isModifySuccess = false;
		System.out.println("딴거나옴?" + request.getParameter("board_pass")+request.getParameter("board_subject"));
		
		
		System.out.println("nowPage?" + nowPage);
		System.out.println("파서인트왜안되?"+request.getParameter("board_num"));
		//수정하려는 게시판 번호
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		//수정 게시물을 검색하여 보관
		BoardBean article = new BoardBean();
		
		//특정 게시물 수정을 위한 Service
		BoardModifyProService boardModifyProService 
		   = new BoardModifyProService();
		
		//게시물 수정시 입력때 입력한 비밀번호를 체크하여
		//게시물 수정하려는 사용자가 맞는지 검증을 하는 부분
		boolean isRightUser = 
			boardModifyProService.isArticleWriter(
					board_num,request.getParameter("board_pass"));
		
		//비밀번호가 틀린 경우 게시판을 수정 못함
		if(!isRightUser) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.')");
			out.println("history.back();");
			out.println("</script>");
			
		}else {//게시물을 수정할 수  있는 사용자이면
			
			
			article.setBoard_num(board_num);
			article.setBoard_subject(request.getParameter("board_subject"));
			article.setBoard_content(request.getParameter("board_content"));
			
			//게시물 수정 작업
			isModifySuccess = boardModifyProService.modifyArticle(article);
			
			//게시물 수정작업이 실패한 경우
			if(!isModifySuccess) {
				
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('게시물 수정이 실패하였습니다.')");
				out.println("history.back();");
				out.println("</script>");
				
			}else {//게시물 수정이 성공한 경우
//http://localhost:8080/BoardListManage/boardDetail.bo?board_num=게시물번호				
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?board_num=" + article.getBoard_num() + "&page=" + nowPage );
			}
			
		}
		
		return forward;
	}

	
}
