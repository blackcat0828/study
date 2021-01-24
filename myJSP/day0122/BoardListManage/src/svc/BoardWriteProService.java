package svc;


import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;

import static db.JdbcUtil.*;

//게시판 등록 처리하는 Business Logic을 구현하는 Sevice 클래스
public class BoardWriteProService {
 
	//신규 게시판 등록처리하는 메서드
	public boolean registArticle(BoardBean boardBean) {
		
		boolean isWriteSuccess = false;
		
		//Connection pool에서 Free한 Connection 연결
		Connection con = getConnection();

		//getInstance()?
		//싱글톤방식으로 최초 한번만 인스턴스를 Heap메모리에 생성하고
		//이후부터는 공유해서 사용한다.
		//BoardDAO ?
		//실제로 데이터베이스에 연동해서 자료를 입출력처리 부분
		BoardDAO boardDAO = BoardDAO.getInstance();
		//connection 연결
		boardDAO.setConnection(con);
		//insertArticle
		//최종적으로 신규게시판 등록처리
		int insertCount = boardDAO.insertArticle(boardBean);
		
		//insert 작업후에 리턴값이 0보다 크다는 이야기는
		//insert 성공
		if(insertCount > 0) {
			commit(con);
			//게시판 작업이 성공했으므로 true로 변경
			isWriteSuccess = true;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return isWriteSuccess;
	}
}