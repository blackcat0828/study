package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;
//게시판 수정하기 요청을 처리하는 Business Logic을 구현하는 Service 클래스
public class BoardModifyProService {

	//사용자가 특정 게시판을 수정할 권한이 있는지 체크
	//isArticleBoardWriter()
	public boolean isArticleWriter(int board_num,String pass) {
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num,pass);
		
		close(con);
		
		return isArticleWriter;
	}
	
	//특정게시판 수정작업 처리
	public boolean modifyArticle(BoardBean article) {
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		//특정 게시판 삭제처리를 한다.
		int updateCount = boardDAO.updateArticle(article);
		
		//정상적으로 update 처리가 되면
		if(updateCount > 0) {
			commit(con);
			isModifySuccess = true;
		}else {//실패
			rollback(con);
		}
		
		close(con);
		
		return isModifySuccess;
	}
	
}