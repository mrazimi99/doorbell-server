package com.cps.doorbell.model;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletInputStream;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DoorBellApplication {
	private static String LOCATION_FILE_NAME = "location.json";
	private static String IMAGE_FILE_NAME = "main.jpg";
	private static String IS_AVAILABLE_FILE_NAME = "available.json";
	private static String TEXT_FILE_NAME = "text.txt";
	private static String DATE_FILE_NAME = "date.txt";
	private static String BASE64_IMAGE_FILE_NAME = "bmage.txt";
	private static DoorBellApplication single_instance = null;

	public static DoorBellApplication getInstance() {
		if (single_instance == null)
			single_instance = new DoorBellApplication();

		return single_instance;
	}

	public void updateLocation(boolean isClose) {
		File locationFile = new File(LOCATION_FILE_NAME);
		try {
			Location newLocation = new Location(isClose);
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

	public void updateImage(ServletInputStream image) {
		try {
			Files.deleteIfExists(Paths.get(IMAGE_FILE_NAME));
			Files.copy(image, Paths.get(IMAGE_FILE_NAME));
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

	public void saveText(String text) {
		try {
			FileWriter textFile = new FileWriter(TEXT_FILE_NAME);
			textFile.write(text);
			textFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getText() {
		try {
			return Files.readString(Path.of(TEXT_FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void setDate(String date) {
		try {
			FileWriter textFile = new FileWriter(DATE_FILE_NAME);
			textFile.write(date);
			textFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getDate() {
		try {
			return Files.readString(Path.of(DATE_FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void saveBase64Image(ServletInputStream base64_image) {
		try {
			Files.deleteIfExists(Paths.get(BASE64_IMAGE_FILE_NAME));
			Files.copy(base64_image, Paths.get(BASE64_IMAGE_FILE_NAME));
			setImageIsAvailable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBase64Image() {
		try {
			return Files.readString(Path.of(BASE64_IMAGE_FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
