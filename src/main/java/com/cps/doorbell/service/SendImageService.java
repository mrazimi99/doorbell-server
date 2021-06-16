package com.cps.doorbell.service;

import com.cps.doorbell.model.DoorBellApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class SendImageService {

	@RequestMapping(value = "image", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public void updateImage(HttpServletRequest request) throws IOException {
		DoorBellApplication.getInstance().updateImage(request.getInputStream());
	}
}
