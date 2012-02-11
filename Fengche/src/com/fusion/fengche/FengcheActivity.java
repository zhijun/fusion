package com.fusion.fengche;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FengcheActivity extends Activity {
	/** Called when the activity is first created. */
	private EditText username;
	private EditText pwd;
	private Button login, register;
	private String TAG="Fengche.Main";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		getCompenet();
		registerListener();
	}

	/**
	 * 
	 */
	private void registerListener() {
		login.setOnClickListener(new MyListener());
	}

	/**
	 * 
	 */
	private void getCompenet() {

		username = (EditText) findViewById(R.id.txt_username);
		pwd = (EditText) findViewById(R.id.txt_pwd);
		login = (Button) findViewById(R.id.btn_login);
		register = (Button) findViewById(R.id.btn_register);
		 
	}

	private class MyListener implements OnClickListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		 */
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())
			{
			case R.id.btn_login:
				Log.i(TAG, "用户: "+username.getText()+"密码: "+pwd.getText()+"登陆正在尝试系统...");
				break;
			case R.id.btn_register:
				
				break;
			}
		}
	}
}
