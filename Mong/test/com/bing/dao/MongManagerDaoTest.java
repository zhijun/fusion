package com.bing.dao;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bing.vo.GeoPoint;
import com.bing.vo.User;

public class MongManagerDaoTest {

	MongManagerDao mongManagerDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("set up Before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("set up .... ");
		mongManagerDao = new MongManagerDao();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testAddUser() {
		mongManagerDao.cleanDB();
		for (int x = 1; x <= 1000; x++) {
			double i = Math.random() + 30;
			double j = Math.random() + 104;

			User user = new User();
			user.setName("bing_3" + x);
			user.setNickName("kaibing");
			user.setShare(1);
			user.setGeoPoint(new GeoPoint(i, j));
			mongManagerDao.addUser(user);

		}

	}

	@Test
	public void testGetNearBy() {
		List<User> user = mongManagerDao.getNearBy(new GeoPoint(30.55, 104.09),
				0.03);
		for (User u : user) {
			System.out.println(u);
		}
	}
}
