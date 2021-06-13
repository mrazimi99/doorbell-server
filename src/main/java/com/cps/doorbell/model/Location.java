package com.cps.doorbell.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	private String x;
	private String y;

	public Location(@JsonProperty("x") String x, @JsonProperty("y") String y) {
		this.x = x;
		this.y = y;
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
}
