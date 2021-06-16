package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetImageAvailableService {

	@RequestMapping(value = "available", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean getImage() {
		return DoorBellApplication.getInstance().isImageIsAvailable();
	}
}
