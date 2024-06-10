package poly.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


import poly.bean.UploadFile;

@Service
@Transactional
public class ImageService {
	
	@Autowired
	@Qualifier("uploadfile")
	UploadFile baseUploadFile;
	
	public String getFileName(MultipartFile filepart) {
		return filepart.getOriginalFilename().replace(" ", "-");
	}

	public String uploadFile(MultipartFile file) {
		String fileName = "";
		if (!file.isEmpty()) {
			try {
				String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
				fileName = date + file.getOriginalFilename();
				String photoPath = baseUploadFile.getBasePath() + "/sach" + File.separator + fileName;
				file.transferTo(new File(photoPath));
				Thread.sleep(3000);
			} catch (IllegalStateException | IOException | InterruptedException e) {
				e.printStackTrace();
				return "0";
			}
		}
		return fileName;
	}
}
