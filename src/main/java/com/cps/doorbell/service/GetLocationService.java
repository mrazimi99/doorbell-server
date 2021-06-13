package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import com.cps.doorbell.model.Location;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLocationService {

	@RequestMapping(value = "location", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Location getLocation() {
		return DoorBellApplication.getInstance().getLocation();
	}
}
