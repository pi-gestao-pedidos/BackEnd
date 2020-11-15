package br.com.pris.pris.controllers;

import java.io.IOException;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.pris.pris.utils.FileUploadUtil;

@RestController
public class UploadController {

	@CrossOrigin
	@PostMapping("/upload")
	public String saveFile(@RequestParam("image")MultipartFile file) {
		String uploadDir = "files";
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			FileUploadUtil.saveFile(uploadDir, fileName, file);
		}
		catch(IOException e) {
			System.out.println("O arquivo não foi salvo " + e);
			return "ERROR: " + e;
		}
		
		System.out.println("O arquivo foi salvo.");
		return uploadDir+ "/" + fileName;
	}
}
