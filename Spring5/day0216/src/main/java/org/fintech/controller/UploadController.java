package org.fintech.controller;

import java.io.File;

import org.fintech.domain.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload Form");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPosst(MultipartFile[] uploadFile,Model model) {
		String uploadFolder = "c:\\upload";
		
		for(MultipartFile mul : uploadFile) {
			log.info("------------------");
			log.info("업로드 파일명:"+mul.getOriginalFilename());
			log.info("업로드 파일크기: "+mul.getSize());
			
			File saveFile = new File(uploadFolder,mul.getOriginalFilename());
			
			try {
				//파일을 저장
				mul.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto,@ModelAttribute("page") int page) {
		log.info("dto:" + dto);
		log.info("page:" + page);
		
		//views 폴더 아래에 sample 폴더에 있는 ex04.jsp를 실행해라
		return "/sample/ex04";
	}
}
