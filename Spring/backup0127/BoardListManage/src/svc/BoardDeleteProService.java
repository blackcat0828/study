package svc;

import java.sql.Connection;

import dao.BoardDAO;

import static db.JdbcUtil.*;

//게시판 삭제처리를 하는 Business Logic Service 클래스
public class BoardDeleteProService {
	
	//특정 게시물 삭제를 하기위해 사용자 권한 체크
	public boolean isArticleWriter(int board_num,String pass) {
		
		boolean isArticleWriter = false;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num,pass);
		
		close(con);
		
		return isArticleWriter;
		
	}
	
	//특정 게시판 삭제처리
	public boolean removeArticle(int board_num) {
		
		boolean isRemoveSuccess = false;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		//특정 게시판 삭제 처리
		int deleteCount = boardDAO.deleteArticle(board_num);
		
		if(deleteCount > 0) {
			commit(con);
			isRemoveSuccess = true;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return isRemoveSuccess;
		
	}
}