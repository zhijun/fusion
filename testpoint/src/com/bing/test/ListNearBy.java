package com.bing.test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.bing.vo.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ListNearBy extends ListActivity {
	private String TAG = "BAIDU";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listnearby);
		Log.i(TAG, "进入列表显示activity");
		Intent itIntent = getIntent();

		Gson gson = new Gson();
		List<User> user = new ArrayList<User>();

		Type type = new TypeToken<List<User>>() {
		}.getType();
		String ulist = itIntent.getStringExtra("ulist");
		if (ulist != null) {
			user = gson.fromJson(ulist, type);
			if (user != null) {

				ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
				for (User u : user) {
					HashMap<String, String> map = new HashMap<String, String>();
					map.put("name", u.getName());
					map.put("nickName", u.getNickName());
					map.put("x", u.getGeoPoint().getLatitude() + "");
					map.put("y", u.getGeoPoint().getLongitude() + "");
					list.add(map);
				}
				SimpleAdapter adapter = new SimpleAdapter(this, list,
						R.layout.listuser, new String[] { "name", "nickName",
								"x", "y" }, new int[] { R.id.name,
								R.id.nickName, R.id.x, R.id.y });
				setListAdapter(adapter);

			}
		}

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Log.i(TAG, position + "条项目被选择");
		super.onListItemClick(l, v, position, id);
	}

}
