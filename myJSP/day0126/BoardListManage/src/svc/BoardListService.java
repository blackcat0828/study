package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;
//게시판 목록 보기 요청을 처리하는 Business Login을 구현하는 Service 클래스
public class BoardListService {

	//게시판 총 건수
	//selectListCount()
	public int getListCount() {
		
		int listCount = 0;
		Connection con = getConnection();
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount();
		
		close(con);
		
		return listCount;
		
	}
	
	//게시판목록을 ArrayList에 대입한다.
	public ArrayList<BoardBean> getArticleList(int page,int limit){
		
		ArrayList<BoardBean> articleList = null;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		boardDAO.setConnection(con);
		//실제로 게시판 목록을 가져온다
		//page : 페이지 번호
		//limit : 1페이징당 보여지는 게시물 갯수(10개)
		articleList = boardDAO.selectArticleList(page,limit);
		
		close(con);
		
		return articleList;
	}
	
}
