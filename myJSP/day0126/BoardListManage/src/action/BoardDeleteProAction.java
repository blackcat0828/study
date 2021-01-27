package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDeleteProService;
import vo.ActionForward;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		//삭제하려는 게시판 번호
		int board_num = Integer.parseInt(request.getParameter("board_num"));

		//게시판 삭제처리후 현재 작업중인 페이지 화면을 유지하기 위해 현재
		//페이지 번호를 가져온다.
		String nowPage = request.getParameter("page");

		//게시판 삭제 처리를 위한 Service 클래스
		BoardDeleteProService boardDeleteProService = new BoardDeleteProService();

		boolean isArticleWriter = boardDeleteProService.isArticleWriter(board_num, request.getParameter("board_pass"));

		//삭제 권한이 없는 사용자인 경우
		if (!isArticleWriter) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다.')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else {//게시판 삭제 권한이 있는 사용자인 경우

			boolean isDeleteSuccess = 
					boardDeleteProService.removeArticle(board_num);

			//게시물 삭제처리가 실패하면
			if (!isDeleteSuccess) {

				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script>");
				out.println("alert('게시물 삭제 실패하였습니다.')");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			} else {//게시물 삭제가 성공하면
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardList.bo?page=" + nowPage);
			}

		}
		return forward;

	}

}
