package com.bing.test;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.Overlay;

public class Myoverylay extends Overlay{
	
	private GeoPoint geoPoint ;
    private Paint paint = new Paint();
    private String text="";
    
 
    public Myoverylay(GeoPoint geoPoint, String text) {
		super();
		this.geoPoint = geoPoint;
		this.text = text;
	}


	@Override
    public void draw(Canvas canvas, MapView mapView, boolean shadow) {
        //在天安门的位置绘制一个String
        Point point = mapView.getProjection().toPixels(geoPoint, null);
        canvas.drawText(text, point.x, point.y, paint);
         
    }

}
