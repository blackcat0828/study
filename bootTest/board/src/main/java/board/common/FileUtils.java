package board.common;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.board.dto.BoardFileDto;
import board.board.entity.BoardFileEntity;

@Component
public class FileUtils {

	public List<BoardFileDto> parseFileInfo(int boardIdx, MultipartHttpServletRequest multiparthttpServletRequest)
			throws Exception {

		// 업로드한 파일이 없는 경우
		if (ObjectUtils.isEmpty(multiparthttpServletRequest)) {
			return null;
		}

		// 첨부파일 테이블 형태의 List 구조를 가진 fileList 참조변수 생성
		List<BoardFileDto> fileList = new ArrayList<>();

		// 날짜타입의 자료를 원하는 패턴으로 보여주기 위한 것으로
		// SimpleDateFormat과 유사함.
		// 업로드 파일을 관리하기 위한 폴더를 생성하기 위해 선언
		// 예를 들어 20210312 이런식으로 폴더 생성
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");

		// 자바 1.8 이후 가능하며 현재시간을 리턴한다.
		ZonedDateTime current = ZonedDateTime.now();
		String path = "images/" + current.format(format);

		// 파일 생성
		File file = new File(path);

		// 현재시간 폴더가 존재하지 않으면 폴더를 생성
		if (file.exists() == false) {
			file.mkdirs();
		}

		Iterator<String> iterator = multiparthttpServletRequest.getFileNames();

		String newFileName, originalFileExtension, contentType;

		while (iterator.hasNext()) {

			List<MultipartFile> list = multiparthttpServletRequest.getFiles(iterator.next());

			for (MultipartFile multipartFile : list) {

				// 첨부파일이 존재하면
				if (multipartFile.isEmpty() == false) {
					// MIME 형태를 가져온다.(image/jpeg,video/mp4)
					contentType = multipartFile.getContentType();

					if (ObjectUtils.isEmpty(contentType)) {
						break;// 반복문을 빠져나온다.
					} else {
						if (contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						} else if (contentType.contains("image/png")) {
							originalFileExtension = ".png";
						} else if (contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						} else {
							break;
						}
					}

					// 서버에 업로드 되는 실제 파일명 생성
					// System.nanoTime() 사용하는 이유?
					// 파일명 중복을 방지하기 위함
					newFileName = Long.toString(System.nanoTime()) + originalFileExtension;

					// 첨부파일을 담기 위한 클래스
					BoardFileDto boardFile = new BoardFileDto();

					// 첨부파일을 업로드하기 위한 게시물 번호
					boardFile.setBoardIdx(boardIdx);
					// 업로드 파일 크기
					boardFile.setFileSize(multipartFile.getSize());
					// 업로드 원본 파일명
					boardFile.setOriginalFileName(multipartFile.getOriginalFilename());
					// 업로드 파일 경로
					boardFile.setStoredFilePath(path + "/" + newFileName);

					// 첨부파일 목록에 추가처리
					fileList.add(boardFile);

					// 파일을 생성
					file = new File(path + "/" + newFileName);

					// 업로드된 파일을 새로운 이름으로 변경하여 지정된 경로에 복사
					multipartFile.transferTo(file);
				}
			}

		}

		return fileList;
	}

	// JPA를 이용한 첨부파일 등록 03.16
	public List<BoardFileEntity> parseFileInfo(MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {

		//업로드한 파일이 없는 경우
		if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
			return null;
		}

		//첨부파일 테이블 형태의 List 구조를 가진 fileList 참조변수 생성
		List<BoardFileEntity> fileList = new ArrayList<>();

		//날짜타입의 자료를 원하는 패턴으로 보여주기 위한 것으로
		//SimpleDateFormat과 유사함.
		//업로드 파일을 관리하기 위한 폴더를 생성하기 위해 선언
		//예를 들어 20210312 이런식으로 폴더 생성 
		DateTimeFormatter format = 
				DateTimeFormatter.ofPattern("yyyyMMdd");
		
		//자바 1.8 이후 가능하며 현재시간을 리턴한다.
		ZonedDateTime current = ZonedDateTime.now();
		String path = "images/" + current.format(format);

		//파일 생성
		File file = new File(path);

		//현재시간 폴더가 존재하지 않으면 폴더를 생성
		if (file.exists() == false) {
			file.mkdirs();
		}

		Iterator<String> iterator = 
				multipartHttpServletRequest.getFileNames();
		
		String newFileName, originalFileExtension, contentType;

		while (iterator.hasNext()) {

			List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());

			for (MultipartFile multipartFile : list) {

				//첨부파일이 존재하면
				if (multipartFile.isEmpty() == false) {
					//MIME 형태를 가져온다.(image/jpeg,video/mp4)
					contentType = multipartFile.getContentType();

					if (ObjectUtils.isEmpty(contentType)) {
						break;//반복문을 빠져나온다.
					} else {
						if (contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						} else if (contentType.contains("image/png")) {
							originalFileExtension = ".png";
						} else if (contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						} else {
							break;
						}
					}

					//서버에 업로드 되는 실제 파일명 생성
					//System.nanoTime() 사용하는 이유?
					//파일명 중복을 방지하기 위함
					newFileName = Long.toString(System.nanoTime()) + originalFileExtension;

					//첨부파일을 담기 위한 클래스
					BoardFileEntity boardFile = new BoardFileEntity();

					//업로드 파일 크기
					boardFile.setFileSize(multipartFile.getSize());
					//업로드 원본 파일명
					boardFile.setOriginalFileName(multipartFile.getOriginalFilename());
					//업로드 파일 경로
					boardFile.setStoredFilePath(path + "/" + newFileName);
					//게시물 작성자
					boardFile.setCreatorId("admin");

					//첨부파일 목록에 추가처리
					fileList.add(boardFile);
					
					//파일을 생성
					file = new File(path + "/" + newFileName);
		            
					//업로드된 파일을 새로운 이름으로 변경하여 지정된 경로에 복사
					multipartFile.transferTo(file);
				}

			}

		}
		 
		return fileList;
	}
}