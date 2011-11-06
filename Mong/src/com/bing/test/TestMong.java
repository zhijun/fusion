package com.bing.test;

import java.net.UnknownHostException;
import java.util.List;

import com.bing.dao.MongManagerDao;
import com.bing.vo.GeoPoint;
import com.bing.vo.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class TestMong {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DB db;
		Mongo m = null;

		try {
			m = new Mongo();

			db = m.getDB("bing");
			// boolean auth=db.authenticate("bing", "Lui1988*".toCharArray());
			// System.out.println(auth);
			/*
			 * Set<String> colls = db.getCollectionNames();
			 * 
			 * for (String s : colls) { System.out.println(s); }
			 */
			DBCollection dc = db.getCollection("userInfo");
			dc.ensureIndex(new BasicDBObject("geoPoint", "2d"));
			dc.ensureIndex(new BasicDBObject("name", 1), "name", true);
			System.out.println("index:" + dc.getIndexInfo());
			/*
			 * BasicDBObject doc = new BasicDBObject(); BasicDBObject point =
			 * new BasicDBObject(); point.put("longitude", 120);
			 * point.put("latitude", 150); doc.put("name", "kaibing");
			 * doc.put("sex", "bog"); doc.put("point", point); dc.save(doc);
			 */
			// System.out.println(dc.findOne());

			// DBCursor mydoc = dc.find(new BasicDBObject("point",new
			// BasicDBObject("$near",new int[]{120,80,1000})));

			/*

*/

			List<User> list = new MongManagerDao().getNearBy(new GeoPoint(
					104.09, 30.55), 200);
			for (User u : list) {
				System.out.println(u);
			}
		} catch (UnknownHostException | MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			m.close();
		}

	}
}
