package com.douzone.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.stereotype.Service;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileuploadService {

	// 디렉토리 이름
	//C드라이브 아래 /upload-images이름의 폴더 만들어 주기
	private static String SAVE_PATH = "/upload-images";
	private static String URL_BASE = "/images";

	public static String restore(MultipartFile multipartFile) {
		String url = null;

		try {
			// 파일을 안 올렸을 경우
			if (multipartFile.isEmpty()) {
				return url;
			}

			String originFilename = multipartFile.getOriginalFilename();

			// 파일 확장자 찾기 (이름이 a.t.image일 경우도 생각해서 lastindexof로 끝 . 을 찾는다.)
			// substring을 이용해 자르기
			String extName = originFilename.substring(originFilename.lastIndexOf('.') + 1);
			String saveFileName = generateSaveFilename(extName);

			// 파일 사이즈
			long filesize = multipartFile.getSize();

			System.out.println("############" + originFilename);
			System.out.println("############" + extName);
			System.out.println("############" + filesize);
			System.out.println("############" + saveFileName);

			// -------디렉토리에 저장하기
			byte[] date = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
			os.write(date);
			os.close();
			
			url =  URL_BASE + "/" + saveFileName;
			
			//파일을 다시 읽어와야 하는데,
			
		} catch (IOException ex) {
			throw new RuntimeException("file upload error : " + ex);
		
		}
		
		return url;
	}

	
	private static String generateSaveFilename(String extName) {
		// 파일이름 앞에 업로드 시간을 붙여 고유 이름을 만들어 내기 위한 메소드

		String filename = "";

		Calendar calendar = Calendar.getInstance();

		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += "." + extName;

		return filename;
	}

}
