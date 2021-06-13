package com.cps.doorbell.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class DoorBellApplication {
	private static String LOCATION_FILE_NAME = "location.json";
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
}
