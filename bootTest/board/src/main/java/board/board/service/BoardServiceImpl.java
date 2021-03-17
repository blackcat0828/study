package board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.board.dto.BoardDto;
import board.board.dto.BoardFileDto;
import board.board.mapper.BoardMapper;
import board.common.FileUtils;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	//첨부파일 업로드 처리 03.12
	@Autowired
	private FileUtils fileUtils;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}

	//신규 게시물 등록 처리 03.09
	@Override
	public void insertBoard(BoardDto board,MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		
		//신규 게시물 등록처리
		boardMapper.insertBoard(board);
		
		//FileUtils를 이용하여 업로드된 파일을 서버에 저장하고
		//리턴되는 업로드 파일명을 받아서 List구조의 list 참조변수에 대입처리 
		List<BoardFileDto> list = 
			fileUtils.parseFileInfo(board.getBoardIdx(),multipartHttpServletRequest);
		
		//리턴된 업로드 파일명들이 존재하면
		//첨부파일 테이블에 업로드 파일정보를 insert 한다.
		if(CollectionUtils.isEmpty(list) == false) {
			boardMapper.insertBoardFileList(list);
		}
			
		/*	//getFileNames()?
			//게시물 입력 폼에서 input type이 file로 선언된 태그에서
			//업로드한 파일명들을 리턴한다. 
			Iterator<String> iterator = 
					multipartHttpServletRequest.getFileNames();
			String name;
			
			//다음에 가져올 데이터가 있느냐 체크
			while(iterator.hasNext()) {
				
				//다음 업로드한 파일명을 가져온다.
				name = iterator.next();
				log.debug("파일명" + name);
				//위에서 가져온 파일명을  이용하여 파일의 정보를 가져온다.
				List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
				
				//향상된 for문(배열일때만 사용가능)
				//list 구조에서 값을 하나씩 가져와서 MultipartFile 형태의
				//multipartFile 변수에 대입처리
				for(MultipartFile multipartFile : list) {
					
					log.debug("파일 내역 표시 시작");
					//업로드한 원본 파일명
					log.debug("파일명:" + multipartFile.getOriginalFilename());
					log.debug("파일크기:" + multipartFile.getSize());
					//MIME 형태로 표시 image/jpeg,video/mp4
					log.debug("파일 컨텐츠 타입:" + multipartFile.getContentType());
					log.debug("파일 내역 표시 종료\n");
				}
				
			}

		}*/
		
	}

	//특정 게시물 상세보기 03.10
	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception {
		
		//특정 게시물 상세보기 처리 03.10
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		
		//첨부파일 목록 멤버변수에 대입 03.12
		List<BoardFileDto> fileList = 
				boardMapper.selectBoardFileList(boardIdx);
		board.setFileList(fileList);
		
		//게시물 목록에서 클릭한 게시물 조회수 처리하기 03.10
		boardMapper.updateHitCount(boardIdx);
		
		return board;
		
	}

	//특정 게시물 수정 처리 03.10
	@Override
	public void updateBoard(BoardDto board) throws Exception {
		boardMapper.updateBoard(board);
		
	}

	//특정 게시물 삭제 처리 03.10
	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
		
	}

	//특정 게시물의 특정 첨부파일 목록 가져오기 03.15
	@Override
	public BoardFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception {
		return boardMapper.selectBoardFileInformation(idx,boardIdx);
	}

}





