package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendTextService {

	@RequestMapping(value = "message", method = RequestMethod.PUT)
	public void updateImage(@RequestParam(value = "text") String text) {
		DoorBellApplication.getInstance().saveText(text);
	}
}
