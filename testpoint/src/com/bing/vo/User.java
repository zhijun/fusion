package com.bing.vo;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String nickName;
	private int share;

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	private GeoPoint geoPoint;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GeoPoint getGeoPoint() {
		return geoPoint;
	}

	public void setGeoPoint(GeoPoint geoPoint) {
		this.geoPoint = geoPoint;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", nickName=" + nickName + ", share="
				+ share + ", geoPoint=" + geoPoint + "]";
	}

}
