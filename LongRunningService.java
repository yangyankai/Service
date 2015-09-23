/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/9/16 3:40:23
 * Project: T
 * File: LongRunningService.java
 * Class: LongRunningService
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.mob.t;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Date;

/**
 * Created by yangyankai on 2015/9/16.
 */
public class LongRunningService extends Service
{
	@Nullable
	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		Log.e("a", "Service");
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				Log.e("a","service executed at  "+new Date().toString());
			}
		}).start();




		return super.onStartCommand(intent, flags, startId);
	}
}
