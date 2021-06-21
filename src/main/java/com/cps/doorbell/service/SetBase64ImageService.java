package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class SetBase64ImageService {

	@RequestMapping(value = "bmage", method = RequestMethod.PUT, consumes = MediaType.TEXT_PLAIN_VALUE)
	public void updateImage(HttpServletRequest request) throws IOException {
		DoorBellApplication.getInstance().saveBase64Image(request.getInputStream());
	}
}
