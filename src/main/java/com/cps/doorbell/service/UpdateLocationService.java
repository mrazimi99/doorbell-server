package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import com.cps.doorbell.model.Location;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateLocationService {

	@RequestMapping(value = "location", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Location updateLocation(@RequestParam(value = "close") boolean close) {
		DoorBellApplication.getInstance().updateLocation(close);
		return DoorBellApplication.getInstance().getLocation();
	}
}
