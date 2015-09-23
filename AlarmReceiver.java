/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/9/16 3:38:45
 * Project: T
 * File: AlarmReceiver.java
 * Class: AlarmReceiver
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.mob.t;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by yangyankai on 2015/9/16.
 */
public class AlarmReceiver extends BroadcastReceiver
{



	@Override
	public void onReceive(Context context, Intent intent)
	{

		Log.e("aaa","receive");

		boolean isServiceRunning = false;
		ActivityManager manager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
		for (ActivityManager.RunningServiceInfo service :manager.getRunningServices(Integer.MAX_VALUE)) {
			if("com.mob.t.LongRunningService".equals(service.service.getClassName())){
				isServiceRunning = true;
			}
		}
		if (!isServiceRunning ) {
			Intent mIntent=new Intent(context,LongRunningService.class);
			mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startService(mIntent);

		}


//		Log.e("a", "receiver");


	}


}
