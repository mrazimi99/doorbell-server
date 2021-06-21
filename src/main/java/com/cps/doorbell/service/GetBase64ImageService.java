package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetBase64ImageService {

	@RequestMapping(value = "bmage", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getLocation() {
		return DoorBellApplication.getInstance().getBase64Image();
	}
}
