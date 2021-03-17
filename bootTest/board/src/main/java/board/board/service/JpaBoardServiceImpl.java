package board.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.board.entity.BoardEntity;
import board.board.entity.BoardFileEntity;
import board.board.repository.JpaBoardRepository;
import board.common.FileUtils;

@Service
public class JpaBoardServiceImpl implements JpaBoardService {
	
	@Autowired
	JpaBoardRepository jpaBoardRepositiory;

	@Autowired
	FileUtils fileUtils;
	
	//게시물 목록을 가져온다.
	/*
		select * 
  		  from t_jpa_board 
	  order by boardIdx desc; 
	 */
	@Override
	public List<BoardEntity> selectBoardList() throws Exception {
		return jpaBoardRepositiory.findAllByOrderByBoardIdxDesc();
	}

	//신규 게시물 등록 처리
	@Override
	public void saveBoard(BoardEntity board, 
			  MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		
		//게시물 작성자
		board.setCreatorId("admin");
		
		//특정 게시물 첨부파일 목록을 가져와서 list 참조변수에 대입
		List<BoardFileEntity> list = 
				fileUtils.parseFileInfo(multipartHttpServletRequest);
		
		//첨부파일 목록이 존재하면
		if(CollectionUtils.isEmpty(list) == false) {
			//BoardEntity.java의 fileList 멤버변수에 첨부파일 목록을 대입
			board.setFileList(list);
		}
		
		//엔터티 정보를 저장
		jpaBoardRepositiory.save(board);
		
	}
	

	//특정 게시물 상세보기
	@Override
	public BoardEntity selectBoardDetail(int boardIdx) throws Exception {

		//Optional ?
		//Java의 Optional 클래스는 자바 8부터 추가되었으며 자바로 코딩시
		//고질적인 문제인 NullPointerException 문제를 해결할 수 있는 방법을 
		//제공한다.
		/*
			@Test(expected = NullpointerException.class)
 	        public void givenNull_whenThrowsErrorOnCreate(){
 	           String name = null;
 	           
 	           //of() 는 null값을 입력받지 않는다는 것을 선언 
 	           Optional<String> opt = Optional.of(name);
 	           //ofNullable() 는 null값을 허용해준다는 선언
 	           Optional<String> opt = Optional.ofNullable(name);
 	        } 
 
		 */
		
		//findById(boardIdx) ?
		//매개변수 boardIdx 에 대한 기본키가 있는지 검색처리
		//select * from t_jpa_board where boardIdx = #{boardIdx}
		Optional<BoardEntity> optional 
		      = jpaBoardRepositiory.findById(boardIdx);

		//검색하여 리턴된 값이 존재하느냐 체크하여
		//리턴된 게시물 내역이 있으면 true 없으면 false
		if(optional.isPresent()) {
			
			//optional.get() ?
			//get() 메서드를 사용하면 Optional 객체에 저장된 값에
			//접근을 할 수 있는데 만약 Optional 객체에 저장된 값이
			//NULL이면 NoSuchElementException 예외가 발생한다
			//따라서 get() 메서드를 호출하기 전에 반드시 optional.isPresent()
			//를 사용하여 Optional 객체에 자료가 존재하는지 체크하는게 중요하다.
			BoardEntity board = optional.get();
			
			//조회수를 증가시켜 준다
			board.setHitCnt(board.getHitCnt() + 1);
			
			//테이블에 변경 내역이 반영된다.
			jpaBoardRepositiory.save(board);
			
			return board;
		}else {
			throw new NullPointerException();
		}
	
	}

	//특정 게시물 삭제처리
	@Override
	public void deleteBoard(int boardIdx) {
		jpaBoardRepositiory.deleteById(boardIdx);
	}

	//특정 게시물에 대한 특정 첨부파일 목록 가져오기
	@Override
	public BoardFileEntity selectBoardFileInformation(int boardIdx, int idx) throws Exception {
		
		//jpaBoardRepositiory 의 findBoardFile 메서드를 수행하여
		//특정 첨부파일 내역을 boardFile 이라는 참조변수에 대입
		BoardFileEntity boardFile = jpaBoardRepositiory.findBoardFile(boardIdx,idx);
		
		return boardFile;
	}

	//페이징 게시물 목록 가져오기 03.17
	@Override
	public Page<BoardEntity> getBoardList(Pageable pageable) {
		
		//삼항연산자
		//현재 페이지 번호가 0이면 page변수에 0를 대입하고
		//page 인덱스는 0로 부터 시작하므로 -1 해준다.
		int page = (pageable.getPageNumber() == 0) ? 0 :
			       (pageable.getPageNumber()-1);
		
		//페이징 처리시 페이지당 보여주는 게시물 갯수 지정
		pageable = PageRequest.of(page,10,Sort.by("boardIdx").descending());
		
		return jpaBoardRepositiory.findAll(pageable);
		
	}

	@Override
	public void updateBoard(BoardEntity board) throws Exception {
		jpaBoardRepositiory.updateBoard(board);
	}

}




