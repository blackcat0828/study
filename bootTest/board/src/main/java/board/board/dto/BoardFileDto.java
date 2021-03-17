package board.board.dto;

import lombok.Data;

@Data
public class BoardFileDto {
	
	private int idx;//첨부파일 일련번호
	private int boardIdx;//게시물 번호
	private String originalFileName;//원본파일 이름
	private String storedFilePath;//파일저장 경로
	private long fileSize;//파일크기
	
}




