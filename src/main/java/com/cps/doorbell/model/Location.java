package com.cps.doorbell.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	private boolean isClose;

	public Location(@JsonProperty("close") boolean isClose) {
		this.isClose = isClose;
	}

	public boolean isClose() {
		return isClose;
	}

	public void setClose(boolean close) {
		isClose = close;
	}
}
