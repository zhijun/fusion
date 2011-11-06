package com.bing.dao;

import java.util.ArrayList;
import java.util.List;

import com.bing.constant.Static;
import com.bing.vo.GeoPoint;
import com.bing.vo.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class MongManagerDao implements MongManagerImpl {
	private DB db;
	private Mongo m;
	private DBCollection dbc;

	public DBCollection getDbc() {
		return dbc;
	}

	public void setDbc(DBCollection dbc) {
		this.dbc = dbc;
	}

	public MongManagerDao() {
		try {
			m = new Mongo();
			db = m.getDB(Static.DB_NAME);
			// boolean auth = db.authenticate("bing", "Lui1988*".toCharArray());
			dbc = db.getCollection(Static.USER_TABLE);
			dbc.ensureIndex(new BasicDBObject("name", 1), "name", true);

			dbc.ensureIndex(new BasicDBObject("geoPoint", "2d"));
			System.out.println("indxueL:   " + dbc.getIndexInfo());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<User> getNearBy(GeoPoint geoPoint, double distance) {

		List<User> list = new ArrayList<User>();

		// 内嵌文档查询: reference to
		// http://www.mongodb.org/display/DOCS/Dot+Notation+%28Reaching+into+Objects%29
		// doc.put("geoPoint.longitude", new BasicDBObject("$gt",
		// geoPoint.getLongitude()-Static.LENGHT).append("$lt",
		// geoPoint.getLongitude()+Static.LENGHT));
		// doc.put("geoPoint.latitude", new BasicDBObject("$gt",
		// geoPoint.getLatitude()-Static.LENGHT).append("$lt",
		// geoPoint.getLatitude()+Static.LENGHT));

		DBCursor mydoc = dbc
				.find(new BasicDBObject("geoPoint", new BasicDBObject(
						"$within", new BasicDBObject("$center", new Object[] {
								new Double[] { geoPoint.getLongitude(),
										geoPoint.getLatitude() }, distance }))));

		for (DBObject dbObject : mydoc) {
			User u = new User();

			u.setName(dbObject.get("name").toString());
			u.setNickName(dbObject.get("nickName").toString());
			DBObject point = (DBObject) (dbObject.get("geoPoint"));
			u.setGeoPoint(new GeoPoint((double) point.get("longitude"),
					(double) point.get("latitude")));
			u.setShare(1); // System.out.println(u);
			list.add(u);
		}

		return list;
	}

	@Override
	public void updateUser(String name, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		BasicDBObject doc = new BasicDBObject();
		doc.put("name", user.getName());
		doc.put("nickName", user.getNickName());
		doc.put("geoPoint", new BasicDBObject("longitude", user.getGeoPoint()
				.getLongitude()).append("latitude", user.getGeoPoint()
				.getLatitude()));
		doc.put("share", user.getShare());
		System.out.println("insert: " + user);
		dbc.save(doc);
	}

	@Override
	public void cleanDB() {
		// TODO Auto-generated method stub
		dbc.drop();
	}

}
