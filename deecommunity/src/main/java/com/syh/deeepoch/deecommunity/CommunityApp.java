package com.syh.deeepoch.deecommunity;

import android.app.Application;
import android.content.Context;
import com.syh.deeepoch.epochcore.IAppLifecycle;
import com.syh.deeepoch.epochcore.IComponentConfig;
import java.util.List;

/**
 * Created by 孙应恒 on 2018/2/5.
 * Description:
 */

public class CommunityApp implements IAppLifecycle,IComponentConfig {
  @Override public void attachBaseContext(Context base) {

  }

  @Override public void onCreate(Application application) {

  }

  @Override public void onTerminate(Application application) {

  }

  @Override public void injectAppLifecycle(Context context, List<IAppLifecycle> iAppLifecycles) {
    iAppLifecycles.add(this);
  }

  @Override public void injectActivityLifecycle(Context context,
      List<Application.ActivityLifecycleCallbacks> lifecycleCallbackses) {

  }
}
