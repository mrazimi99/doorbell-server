package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import com.cps.doorbell.model.Location;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetTextService {

	@RequestMapping(value = "message", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getLocation() {
		return DoorBellApplication.getInstance().getText();
	}
}
