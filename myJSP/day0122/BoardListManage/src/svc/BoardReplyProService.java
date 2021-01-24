package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;
//댓글입력 요청을 처리하는 Service 클래스
public class BoardReplyProService {

	public boolean replyArticle(BoardBean article) {
		
		boolean isReplySuccess = false;
		int insertCount = 0;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		//특정 게시판에 대한 댓글 입력처리
		insertCount = boardDAO.insertReplyArticle(article);
		
		if(insertCount > 0) {
			commit(con);
			isReplySuccess = true;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return isReplySuccess;
	}
}
