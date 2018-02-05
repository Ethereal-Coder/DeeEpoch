package com.syh.deeepoch.epochcore;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public class EpochApplication extends Application {
  private static EpochApplication instance;
  private ApplicationDelegate applicationDelegate;

  public static EpochApplication getInstance() {
    return instance;
  }

  @Override public void onCreate() {
    super.onCreate();
    ARouter.openLog();     // 打印日志
    ARouter.openDebug();
    ARouter.init(this);

    instance = this;
    applicationDelegate.onCreate(this);
  }

  @Override public void onTerminate() {
    super.onTerminate();
    applicationDelegate.onTerminate(this);
  }

  @Override protected void attachBaseContext(Context context) {
    super.attachBaseContext(context);
    applicationDelegate  = new ApplicationDelegate();
    applicationDelegate.attachBaseContext(context);
    MultiDex.install(this);
  }
}
