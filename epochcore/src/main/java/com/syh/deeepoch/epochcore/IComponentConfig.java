package com.syh.deeepoch.epochcore;

import android.app.Application;
import android.content.Context;
import java.util.List;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public interface IComponentConfig {
  void injectAppLifecycle(Context context, List<IAppLifecycle> iAppLifecycles);

  void injectActivityLifecycle(Context context,
      List<Application.ActivityLifecycleCallbacks> lifecycleCallbackses);
}
