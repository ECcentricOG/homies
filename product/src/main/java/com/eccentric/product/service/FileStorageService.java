package com.eccentric.product.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

	@Value("${files.upload-dir}")
	private String uploadDir;

	public String saveFile(MultipartFile file) {
		try {
			File dir = new File(uploadDir);
			if (!dir.exists()) dir.mkdirs();
			String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			String filePath = uploadDir + File.separator + fileName;
			file.transferTo(new File(filePath));
			return fileName;
		} catch(Exception e) {
			throw new RuntimeException("Failed to upload a file", e);
		}
	}

	public String getUploadDir() {
		return uploadDir;
	}
}
