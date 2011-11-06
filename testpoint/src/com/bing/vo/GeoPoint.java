package com.bing.vo;

import java.io.Serializable;

public class GeoPoint implements Serializable {
	private double longitude;
	private double latitude;

	public GeoPoint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeoPoint(double longitude, double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "GeoPoint [longitude=" + longitude + ", latitude=" + latitude
				+ "]";
	}

}
