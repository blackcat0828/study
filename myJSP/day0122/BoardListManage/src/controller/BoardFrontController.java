package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardDeleteProAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardModifyFormAction;
import action.BoardModifyProAction;
import action.BoardReplyFormAction;
import action.BoardReplyProAction;
import action.BoardWriteProAction;
import vo.ActionForward;

//@WebServlet("*.bo")
//보안
//어노테이션을 이용한 서블릿 설정
//BoardManage : 프로젝트 이름
//http://localhost:8080/BoardListManage/BoardWrite.bo
//http://localhost:8080/BoardListManage/BoardDelete.bo
@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardFrontController() {
        super();
    }
    
    //실질적인 처리
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
    	request.setCharacterEncoding("UTF-8");
    	
    	//예를 들어
    	//주소 : http://localhost:8080/board/list.jsp
    	//request.getRequestURI() 
    	//프로젝트명과 파일의 경로까지 모두 리턴
    	//리턴값 ===> /board/list.jsp
    	
    	//request.getContextPath()
    	//프로젝트 경로만 가져온다.
    	//리턴값 ===> /board
    	
    	//http://localhost:8080/BoardListManage/boardWriteForm.bo
    	//결과값 : /BoardListManage/boardWriteForm.bo
    	String RequestURI = request.getRequestURI();
    	//결과값 : /BoardListManage
    	String contextPath = request.getContextPath();
    	
    	String command = RequestURI.substring(contextPath.length());
    	
    	ActionForward forward = null;
    	Action action = null;
    	
    	//게시판 신규 등록 화면 입력 폼
    	//http://localhost:8080/BoardListManage/boardWriteForm.bo 로
    	//클라이언트에서 요청이 오면
    	//WebContent 밑에 있는 board 폴더에 있는 qna_board_write.jsp으로
    	//제어권이 넘어간다.
    	if(command.equals("/boardWriteForm.bo")) {
    		forward = new ActionForward();
    		forward.setPath("/board/qna_board_write.jsp");
    	}else if(command.equals("/boardWritePro.bo")) {//버튼클릭시 실제처리
    		action = new BoardWriteProAction();
    		
    		try {
    			forward = action.execute(request,response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	 //게시판 전체 리스트	
    	 //http://localhost:8080/BoardListManage/boardList.bo	
    	}else if(command.equals("/boardList.bo")) {
    		action = new BoardListAction();
    		
    		try {
    			forward = action.execute(request,response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	
    	 //특정 게시물의 상세보기	
       	 //http://localhost:8080/BoardListManage/boardDetail.bo	
    	}else if(command.equals("/boardDetail.bo")) {
    		action = new BoardDetailAction();
    		
    		try {
    			forward = action.execute(request,response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	
    	//특정 게시물 댓글 입력 폼	
        //http://localhost:8080/BoardListManage/boardReplyForm.bo		
    	}else if(command.equals("/boardReplyForm.bo")) {
    		action = new BoardReplyFormAction();
    		
    		try {
    			forward = action.execute(request,response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		//특정 게시물 댓글 입력 처리	
            //http://localhost:8080/BoardListManage/boardReplyPro.bo	    		
    	}else if(command.equals("/boardReplyPro.bo")) {
    		action = new BoardReplyProAction();
    		
    		try {
    			forward = action.execute(request,response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	
    		//특정 게시물 수정 폼	
            //http://localhost:8080/BoardListManage/boardMoifyFormPro.bo    		
    	}else if(command.equals("/boardMoifyForm.bo")) {
    		action = new BoardModifyFormAction();
    		
    		try {
    			forward = action.execute(request,response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		//특정 게시물 수정 처리	
            //http://localhost:8080/BoardListManage/boardMoifyPro.bo    		
    	}else if(command.equals("/boardMoifyPro.bo")) {
    		action = new BoardModifyProAction();
    		
    		try {
    			forward = action.execute(request,response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	
    	//특정 게시물 삭제 폼	
        //http://localhost:8080/BoardListManage/boardDeleteForm.bo   		
    	}else if(command.equals("/boardDeleteForm.bo")) {
    		
    		String nowPage = request.getParameter("page");
    		request.setAttribute("page",nowPage);
    		
    		int board_num = Integer.parseInt(request.getParameter("board_num"));
    		request.setAttribute("board_num",board_num);
    		
    		forward = new ActionForward();
    		forward.setPath("/board/qna_board_delete.jsp");
    	//특정 게시물 삭제 처리	
        //http://localhost:8080/BoardListManage/boardDeletePro.bo    		
    	}else if(command.equals("/boardDeletePro.bo")) {
    		action = new BoardDeleteProAction();
    		
    		try {
    			forward = action.execute(request,response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if(forward != null) {
    		
    		//해당 URL이 Redirect 처리되면 True 아니면 False
    		//response.sendRedirect(URL) 은
    		//강제로 URL로 제어권이 넘어간다.
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		}else {
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			//forward 방식은 a.jsp -> b.jsp로 제어권은 넘기고
    			//a.jsp의 request,response 객체의 속성은 b.jsp와 공유한다.
    			dispatcher.forward(request, response);
    		}
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
