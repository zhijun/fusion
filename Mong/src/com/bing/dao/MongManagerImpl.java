package com.bing.dao;

import java.util.List;

import com.bing.vo.GeoPoint;
import com.bing.vo.User;

public interface MongManagerImpl {
	List<User> getNearBy(GeoPoint geoPoint, double distince);

	void updateUser(String name, User user);

	void addUser(User user);

	void cleanDB();
}
