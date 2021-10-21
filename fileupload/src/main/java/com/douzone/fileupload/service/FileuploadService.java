package com.douzone.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileuploadService {

	public static String restore(MultipartFile multipartFile) {
		String url = null;
		
		//파일을 안 올렸을 경우
		if(multipartFile.isEmpty()) {
			return url;
		}
		
		
		
		return url;
	}

}
