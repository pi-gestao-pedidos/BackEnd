package br.com.pris.pris.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.pris.pris.utils.FileUploadUtil;

@RestController
@CrossOrigin
public class UploadController {

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
	
	@GetMapping("/download/{image}")
	public ResponseEntity<ByteArrayResource> showFile(@PathVariable ("image") String image) {
		if (!image.equals("") || image !=null) {
			try {
				Path filename = Paths.get("files", image);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok()
						.contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/png"))
						.body(byteArrayResource);
				
			} catch (Exception e) {
				
			}
		}
		return ResponseEntity.badRequest().build();
	}
}
