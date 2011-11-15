/**
 * 
 */
package com.fusion.model.core;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Id;

/**
 * @author zhijun
 *
 */
public class User {
	@Id ObjectId id;
	private String uid;
	private String userType;
	private String nickName;
	private Date registerDate;
	private int points;
	private Credits credit;
	private Profile profile;
	private float[] location;

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the registerDate
	 */
	public Date getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate
	 *            the registerDate to set
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the credit
	 */
	public Credits getCredit() {
		return credit;
	}

	/**
	 * @param credit
	 *            the credit to set
	 */
	public void setCredit(Credits credit) {
		this.credit = credit;
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * @return the location
	 */
	public float[] getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(float[] location) {
		this.location = location;
	}
}
