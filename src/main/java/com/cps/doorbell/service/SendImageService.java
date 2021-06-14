package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SendImageService {

	@RequestMapping(value = "image", method = RequestMethod.PUT)
	public void updateImage(@RequestParam(value = "image") MultipartFile file) {
		if (file.getContentType().contains("image"))
			DoorBellApplication.getInstance().updateImage(file);
	}
}
