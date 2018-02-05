package com.syh.deeepoch.epochcore;

import android.app.Application;
import android.content.Context;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public interface IAppLifecycle {
  void attachBaseContext(Context base);

  void onCreate(Application application);

  void onTerminate(Application application);
}
