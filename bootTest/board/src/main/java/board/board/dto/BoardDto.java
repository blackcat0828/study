package board.board.dto;

import java.util.List;

import lombok.Data;

@Data
public class BoardDto {

	//Camel Case 표기법:단어와 단어로 이루어진 경우 뒷단어 첫째자리는 대문자로 표기
	//Snake Case 표기법:변수명을 작성시 _를 이용하여 작성한다 board_Idx
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private String createdDatetime;
	private String updaterId;
	private String updatedDatetime;
	
	//첨부파일 목록 가져오기 03.12
	private List<BoardFileDto> fileList;
	
}






