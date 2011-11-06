package com.bing.test;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.baidu.mapapi.ItemizedOverlay;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.OverlayItem;
import com.baidu.mapapi.Projection;

public class MyItemOverylay extends ItemizedOverlay<OverlayItem> {

	private List<OverlayItem> overlayItemlist = new ArrayList<OverlayItem>();
	private Context context;

	public MyItemOverylay(Drawable arg0) {
		super(boundCenterBottom(arg0));
		// TODO Auto-generated constructor stub
	}

	public MyItemOverylay(Drawable drawable, Context context) {
		super(drawable);
		this.context = context;
	}

	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return overlayItemlist.get(i);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return overlayItemlist.size();
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean flag) {
		// TODO Auto-generated method stub
		super.draw(canvas, mapView, flag);
		Projection projection = mapView.getProjection();
		for (int x = size() - 1; x >= 0; x--) {
			OverlayItem oi = overlayItemlist.get(x);
			Point point = projection.toPixels(oi.getPoint(), null);

			Paint text = new Paint();
			text.setColor(Color.RED);
			text.setTextSize(13);
			canvas.drawText(oi.getTitle(), point.x + 10, point.y - 10, text);
		}
	}

	@Override
	protected boolean onTap(int i) {
		// TODO Auto-generated method stub
		setFocus(overlayItemlist.get(i));
		Toast.makeText(this.context, overlayItemlist.get(i).getSnippet(),
				Toast.LENGTH_SHORT).show();
		return super.onTap(i);
	}
	public void addOverlay(OverlayItem overlayItem) {  
        overlayItemlist.add(overlayItem);  
        this.populate();  
    }  
}
