package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import com.cps.doorbell.model.Location;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetImageService {

	@RequestMapping(value = "image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity getImage() {
		byte[] image = DoorBellApplication.getInstance().getImage();

		if (image != null)
			return ResponseEntity.ok(image);

		return ResponseEntity.notFound().build();
	}
}
