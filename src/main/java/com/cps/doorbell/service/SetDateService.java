package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetDateService {

	@RequestMapping(value = "date", method = RequestMethod.PUT)
	public void setDate(@RequestParam(value = "date") String date) {
		DoorBellApplication.getInstance().setDate(date);
	}
}
