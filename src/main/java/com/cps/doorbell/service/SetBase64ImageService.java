package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetBase64ImageService {

	@RequestMapping(value = "bmage", method = RequestMethod.PUT)
	public void updateImage(@RequestParam(value = "value") String base64_image) {
		DoorBellApplication.getInstance().saveBase64Image(base64_image);
	}
}
