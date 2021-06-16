package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetImageAvailableService {

	@RequestMapping(value = "available", method = RequestMethod.PUT)
	public void updateLocation(@RequestParam(value = "flag") boolean isAvailable) {
		DoorBellApplication.getInstance().setImageIsAvailable(isAvailable);
	}
}
