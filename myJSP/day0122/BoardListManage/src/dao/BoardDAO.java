package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.BoardBean;

import static db.JdbcUtil.*;

//데이터베이스와 연동처리
public class BoardDAO {
	
	DataSource ds;
	Connection con;
	private static BoardDAO boardDAO;
	
	private BoardDAO() {}
	
	//싱글톤패턴을 이용해서 인스턴스를 한번만 Heap메모리에 생성하고
	//생성된 이후에는 공유해서 사용한다.
	public static BoardDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		
		return boardDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	//게시판 데이터 총건수
	public int selectListCount() {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select count(*) from board";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		}catch(Exception ex) {
			System.out.println("selectListCount() 에러:" + ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}
	
	//게시판 목록 리스트 불러오기
	public ArrayList<BoardBean> selectArticleList(int page,int limit){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//서버에 부담을 줄이고 한 페이지당 10개씩 보여주기 위해
		//mysql에서 제공해주는 limit를 사용한다
		//예를들어
		//select * from board limit 4,10; 인경우
		//리턴된  5번째 행부터 10개를 가져오라는 의미
		//댓글번호는 내림차순이고 댓글일련번호는 오름차순이다.
		String board_list_sql = 
			 "select * from board" + 
		     " order by board_re_ref desc,board_re_seq asc limit ?,10";
		
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		
		BoardBean board = null;
		
		//페이지당 첫번째 행번호를 알기 위해 계산
		int startrow = (page-1)*10;
		
		try {
			
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1,startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardBean();
				
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getDate("board_date"));
				
				articleList.add(board);
				
			}
		}catch(Exception ex) {
			System.out.println("getBoardList() 에러:" + ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return articleList;
	}
	
	
	public BoardBean selectArticle(int board_num) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;
		String sql;
		
		try {
			
			sql = "select * from board where board_num = ?";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				boardBean = new BoardBean();
				
				boardBean.setBoard_num(rs.getInt("board_num"));
				boardBean.setBoard_name(rs.getString("board_name"));
				boardBean.setBoard_subject(rs.getString("board_subject"));
				boardBean.setBoard_content(rs.getString("board_content"));
				boardBean.setBoard_file(rs.getString("board_file"));
				boardBean.setBoard_re_ref(rs.getInt("board_re_ref"));
				boardBean.setBoard_re_lev(rs.getInt("board_re_lev"));
				boardBean.setBoard_re_seq(rs.getInt("board_re_seq"));
				boardBean.setBoard_readcount(rs.getInt("board_readcount"));
				boardBean.setBoard_date(rs.getDate("board_date"));
			}
			
		}catch(Exception ex) {
			System.out.println("getDetail() 에러:" + ex);
		}
		return boardBean;
	}
	
	public int insertArticle(BoardBean article) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num=0;
		String sql;
		int insertCount=0;
		
		try {
			
			sql = "select max(board_num) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}else {
				num = 1;
			}	
			sql = "insert into board" + 
			      "     values(?,?,?,?,?,?,?,?,?,?,now())";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,num);
			pstmt.setString(2,article.getBoard_name());
			pstmt.setString(3,article.getBoard_pass());
			pstmt.setString(4,article.getBoard_subject());
			pstmt.setString(5,article.getBoard_content());
			pstmt.setString(6,article.getBoard_file());
			pstmt.setInt(7,num);
			pstmt.setInt(8,0);
			pstmt.setInt(9,0);
			pstmt.setInt(10,0);
			
			insertCount = pstmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("getDetail() 에러:" + ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}
	
	
	public int insertReplyArticle(BoardBean article) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_max_sql = "select max(board_num) from board";
		String sql="";
		int num=0;
		int insertCount=0;
		int re_ref = article.getBoard_re_ref();
		int re_lev = article.getBoard_re_lev();
		int re_seq = article.getBoard_re_seq();
		
		
		try {
			
			pstmt = con.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}else {
				num = 1;
			}
			
			sql = "update board" + 
			      "   set board_re_seq = board_re_seq + 1" +
				  " where board_re_ref = ? and board_re_seq > ?";	
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,re_ref);
			pstmt.setInt(2,re_seq);
			
			int updateCount = pstmt.executeUpdate();
			
			if(updateCount > 0) {
				commit(con);
			}
			
			re_seq = re_seq + 1;
			re_lev = re_lev + 1;
			
			sql = "insert into board" + 
			      "      values(?,?,?,?,?,?,?,?,?,?,now())";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,num);
			pstmt.setString(2,article.getBoard_name());
			pstmt.setString(3,article.getBoard_pass());
			pstmt.setString(4,article.getBoard_subject());
			pstmt.setString(5,article.getBoard_content());
			pstmt.setString(6,"");
			pstmt.setInt(7,re_ref);
			pstmt.setInt(8,re_lev);
			pstmt.setInt(9,re_seq);
			pstmt.setInt(10,0);

			insertCount = pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			System.out.println("boardReply() 에러:" + ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}
	
	public int updateArticle(BoardBean article) {
		
		int updateCount = 0 ;
		PreparedStatement pstmt = null;
		String sql = "update board" + 
		             "   set board_subject = ?," +
				     "       board_content = ?" +
		             "  where board_num = ?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,article.getBoard_subject());
			pstmt.setString(2,article.getBoard_content());
			pstmt.setInt(3,article.getBoard_num());
			
			updateCount = pstmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("boardModify() 에러:" + ex);
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	
	public int deleteArticle(int board_num) {
		
		PreparedStatement pstmt = null;
		String board_delete_sql = "delete from board where boar_num = ?";
		
		int deleteCount=0;
		
		try {
			
			pstmt = con.prepareStatement(board_delete_sql);
			pstmt.setInt(1,board_num);
			deleteCount = pstmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("deleteArticle() 에러:" + ex);
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
	public int updateReadCount(int board_num) {
		
		PreparedStatement pstmt = null;
		int updateCount=0;
		String sql = "update board" +
		             "   set board_readcount = board_readcount + 1" +
				     " where board_num = " + board_num;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
					
		}catch(SQLException ex) {
			System.out.println("updateReadCount() 에러:" + ex);
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	public boolean isArticleBoardWriter(int board_num,String pass) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_sql = "select * from board where board_num = ?";
		boolean isWriter = false;
		
		try {
			
			pstmt = con.prepareStatement(board_sql);
			pstmt.setInt(1,board_num);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			if(pass.equals(rs.getString("board_pass"))) {
				isWriter = true;
			}
		}catch(SQLException ex) {
			System.out.println("isArticleBoardWriter() 에러:" + ex);
		}finally {
			close(pstmt);
		}
		
		return isWriter;
	}
	
	
}//end
