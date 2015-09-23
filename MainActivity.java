/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/9/16 10:29:45
 * Project: T
 * File: MainActivity.java
 * Class: MainActivity
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.mob.t;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{



	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent intent=new Intent(this,LongRunningService.class);
		startService(intent);


		Log.e("a", "mainActivity");
		IntentFilter filter=new IntentFilter();
		filter.addAction(Intent.ACTION_TIME_TICK);
		MyBroadcaseReceiver receiver=new MyBroadcaseReceiver();
		registerReceiver(receiver, filter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.a)
		{
			Log.e("a", "main threat id " + Thread.currentThread().getId());


			return true;
		}
		if (id == R.id.s)
		{

			return true;

		}

		return super.onOptionsItemSelected(item);
	}
}
