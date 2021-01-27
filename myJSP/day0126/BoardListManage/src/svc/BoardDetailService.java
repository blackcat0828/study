package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;
//특정 게시판 상세보기 요청을 처리하는 Business Logic을 구현하는 Service 클래스
public class BoardDetailService {

	public BoardBean getArticle(int board_num) {
		
		BoardBean article = null;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		//게시판에서 특정 게시판을 클릭하면 조회수를 1 증가시킨다.
		int updateCount = boardDAO.updateReadCount(board_num);
		
		//조회수를 정상적으로 update 하면
		if(updateCount > 0) {
			commit(con);
		}else {//실패
			rollback(con);
		}
		
		//특정 게시판 정보를 가져와서 BoardBean 에 대입
		article = boardDAO.selectArticle(board_num);
		System.out.println("가져온값 확인 서비스페이지"+article.getBoard_name());
		
		close(con);
		
		return article;
		
	}
}
