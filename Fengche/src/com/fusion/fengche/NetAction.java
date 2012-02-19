package com.fusion.fengche;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class NetAction extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		try {
			String username = (String) (this.getIntent().getExtras()
					.getString("username"));
			String pwd = (String) (this.getIntent().getExtras()
					.getString("pwd"));

			if (request(username, pwd).contains("202"))
				setResult(Activity.RESULT_OK, new Intent(this,
						FengcheActivity.class));
			else
				setResult(Activity.RESULT_CANCELED, new Intent(this,
						FengcheActivity.class));

			finish();
		} catch (Exception e) {
			Log.i("Fengche.Main", "用户: " + e.toString());
		}
	}

	public String request(String username, String pwd) {

		HttpClient httpclient = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"http://10.0.0.4:8080/FusionWeb/login.jsp?username=" + username
						+ "&pwd=" + pwd);

		String response;

		try {
			response = httpclient.execute(request, new BasicResponseHandler());
			Log.v("runState", response);
			return response;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
