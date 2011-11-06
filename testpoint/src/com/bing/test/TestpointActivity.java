package com.bing.test;

import java.lang.reflect.Type;
import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.LocationListener;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.MKLocationManager;
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.MyLocationOverlay;
import com.baidu.mapapi.Overlay;
import com.baidu.mapapi.OverlayItem;
import com.bing.vo.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TestpointActivity extends MapActivity implements LocationListener {
	/** Called when the activity is first created. */

	public static final int LIST_ID = Menu.FIRST;
	BMapManager bMapManager = null;
	MKGeneralListener mkl = null;
	MapController mapController = null;
	MKLocationManager locationManager;
	private String TAG = "BAIDU";
	GeoPoint myPoint = null;
	MapView mapView;
	MyItemOverylay tempLay;
	MyLocationOverlay myLocationOverlay;
	List<User> user;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		bMapManager = new BMapManager(getApplication());
		bMapManager.init("0F491A1CCA9CE5BD4F7D957A25AA7B2BCE9AA83F",
				new MKGeneralListener() {

					public void onGetPermissionState(int arg0) {

						Toast.makeText(getApplicationContext(),
								"百度KEY错误: 请检查 " + arg0, Toast.LENGTH_LONG)
								.show();

					}

					public void onGetNetworkState(int arg0) {
						Toast.makeText(getApplicationContext(),
								"网络错误,无法检查百度KEY:  " + arg0, Toast.LENGTH_LONG)
								.show();

					}
				});
		super.initMapActivity(bMapManager);
		mapView = (MapView) findViewById(R.id.bmapsView);
		mapView.setBuiltInZoomControls(true); // 启用内置缩放控件
		mapController = mapView.getController();

		locationManager = bMapManager.getLocationManager();
		locationManager.requestLocationUpdates(this); // 注册监听事件
		myLocationOverlay = new MyLocationOverlay(this, mapView);

		GeoPoint point = new GeoPoint((int) (30.55 * 1E6), (int) (104.09 * 1E6));

		mapController.setCenter(point); // 设置地图中心
		mapController.setZoom(12); // 设置地图缩放级别
		myLocationOverlay.enableMyLocation(); // 打开自己地理位置
		myLocationOverlay.enableCompass(); // 打开指南针
		Log.i(TAG, "打开指南针");
		mapView.getOverlays().add(myLocationOverlay); // 添加自己地理位置图层
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void onDestroy() {
		if (bMapManager != null) {
			bMapManager.destroy();
			bMapManager = null;
		}
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		if (bMapManager != null) {
			bMapManager.stop();
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		if (bMapManager != null) {
			bMapManager.start();
		}
		super.onResume();
	}

	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		if (location != null) {

			double x = location.getLatitude();
			double y = location.getLongitude();
			Log.i(TAG, "地理位置更新: 经度-->" + x + "  纯度-->" + y);

			NearBy nb = new NearBy(x, y);
			user = nb.getNear();
			Log.i(TAG, "返回userlist");
			List<Overlay> mapoverlay = mapView.getOverlays();
			/*
			 * if (tempLay != null) { mapoverlay.remove(tempLay); }
			 */

			if (user.size() != 0) {
				Drawable marke = this.getResources().getDrawable(
						R.drawable.icon_marka);
				marke.setBounds(0, 0, marke.getIntrinsicWidth(),
						marke.getIntrinsicHeight());
				Log.i(TAG, "创建附近图层");
				MyItemOverylay itemOverylay = new MyItemOverylay(marke, this);
				OverlayItem oi;
				for (User u : user) {
					Log.i(TAG, "获取附近" + u);
					double i = u.getGeoPoint().getLongitude() * 1E6;
					double j = u.getGeoPoint().getLatitude() * 1E6;
					oi = new OverlayItem(new GeoPoint((int) i, (int) j), "姓名:"
							+ u.getName(), "地点1 ");
					itemOverylay.addOverlay(oi);
					Log.i(TAG, "添加图层");
				}

				tempLay = itemOverylay;
				// mapoverlay.remove(itemOverylay);
				mapoverlay.add(itemOverylay);
			}
			// mapView.getOverlays().add(myLocationOverlay);

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		Log.i(TAG, "创建菜单");
		menu.add(0, 1, LIST_ID, "列表显示");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case LIST_ID:
			Log.i(TAG, "点击列表显示");
			listNearby(user);
			break;

		}
		return super.onOptionsItemSelected(item);
	}

	public void listNearby(List<User> ulist) {
		Intent it = new Intent(TestpointActivity.this, ListNearBy.class);

		Type type = new TypeToken<List<User>>() {
		}.getType();
		String beanListToJson = new Gson().toJson(ulist, type);
		it.putExtra("ulist", beanListToJson);
		startActivity(it);

	}
}