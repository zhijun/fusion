package com.bing.test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

import com.bing.vo.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class NearBy {
	// private String requestUrl="http://www.baidu.com";
	private String requestUrl = "http://10.0.2.2:8080/Mong/GetNearBy?";
	// private String requestUrl =
	// "http://10.0.2.2:8080/Mong/GetNearBy?x=104.099999999&y=30.55";
	private String TAG = "BAIDU";
	private double x;
	private double y;
	HttpClient client = new DefaultHttpClient();

	public NearBy(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		requestUrl = requestUrl + "x=" + this.x + "&y=" + this.y;
		Log.i(TAG, "请求的request:" + requestUrl);
	}

	private String get() {
		String result = null;
		try {
			HttpGet get = new HttpGet(requestUrl);
			HttpResponse response;
			Log.i(TAG, "查询http" + requestUrl);
			response = client.execute(get);
			Log.i(TAG, "返回代码:" + response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				Log.i(TAG, "查询http OK");
				result = EntityUtils.toString(response.getEntity());
				Log.i(TAG, "reslut:" + result);
			} else {

			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<User> getNear() {
		Gson gson = new Gson();
		List<User> user = new ArrayList<User>();
		String result = this.get();
		if (result == null) {
			return user;
		}
		Type type = new TypeToken<List<User>>() {
		}.getType();

		user = gson.fromJson(get(), type);
		Log.i(TAG, "user" + user.size());

		return user;
	}

}
