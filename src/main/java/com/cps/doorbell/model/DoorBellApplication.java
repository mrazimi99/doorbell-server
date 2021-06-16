package com.cps.doorbell.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class DoorBellApplication {
	private static String LOCATION_FILE_NAME = "location.json";
	private static String IMAGE_FILE_NAME = "main.jpg";
	private static String IS_AVAILABLE_FILE_NAME = "available.json";
	private static DoorBellApplication single_instance = null;

	public static DoorBellApplication getInstance() {
		if (single_instance == null)
			single_instance = new DoorBellApplication();

		return single_instance;
	}

	public void updateLocation(String x, String y) {
		File locationFile = new File(LOCATION_FILE_NAME);
		try {
			Location newLocation = new Location(x, y);
			new ObjectMapper().writer(new DefaultPrettyPrinter()).writeValue(locationFile, newLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Location getLocation() {
		Location location = null;
		try {
			location = new ObjectMapper().readValue(new File(LOCATION_FILE_NAME), Location.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}

	public void updateImage(MultipartFile image) {
		try {
			FileOutputStream imageWriter = new FileOutputStream(IMAGE_FILE_NAME);
			imageWriter.write(image.getBytes());
			setImageIsAvailable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public byte[] getImage() {
		try {
			return new FileInputStream(IMAGE_FILE_NAME).readAllBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setImageIsAvailable(boolean isAvailable) {
		File booleanFile = new File(IS_AVAILABLE_FILE_NAME);
		try {
			new ObjectMapper().writer(new DefaultPrettyPrinter()).writeValue(booleanFile, isAvailable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isImageIsAvailable() {
		boolean isAvailable = false;
		try {
			isAvailable = new ObjectMapper().readValue(new File(IS_AVAILABLE_FILE_NAME), Boolean.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAvailable;
	}
}
