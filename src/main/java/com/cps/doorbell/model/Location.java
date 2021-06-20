package com.cps.doorbell.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	private String x;
	private String y;
	private String distance;

	public Location(@JsonProperty("x") String x, @JsonProperty("y") String y, @JsonProperty("d") String distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
}
