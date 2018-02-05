package com.syh.deeepoch.epochcore;

import android.app.Application;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public class ApplicationDelegate implements IAppLifecycle {
  private List<IComponentConfig> componentConfigs;
  private List<IAppLifecycle> appLifecycles;
  private List<Application.ActivityLifecycleCallbacks> liferecycleCallbacks;

  public ApplicationDelegate() {
    appLifecycles = new ArrayList<>();
    liferecycleCallbacks = new ArrayList<>();
  }

  @Override public void attachBaseContext(Context context) {
    ManifestParse manifestParse = new ManifestParse(context);
    componentConfigs = manifestParse.parse();
    if (componentConfigs != null && componentConfigs.size() > 0) {
      for (IComponentConfig componentConfig : componentConfigs) {
        componentConfig.injectAppLifecycle(context, appLifecycles);
        componentConfig.injectActivityLifecycle(context, liferecycleCallbacks);
      }
    }

    if (appLifecycles != null && appLifecycles.size() > 0) {
      for (IAppLifecycle appLifecycle : appLifecycles) {
        appLifecycle.attachBaseContext(context);
      }
    }
  }

  @Override public void onCreate(Application application) {
    if (appLifecycles != null && appLifecycles.size() > 0) {
      for (IAppLifecycle appLifecycle : appLifecycles) {
        appLifecycle.onCreate(application);
      }
    }
    if (liferecycleCallbacks != null && liferecycleCallbacks.size() > 0) {
      for (Application.ActivityLifecycleCallbacks lifecycleCallbacks : liferecycleCallbacks) {
        application.registerActivityLifecycleCallbacks(lifecycleCallbacks);
      }
    }
  }

  @Override public void onTerminate(Application application) {
    if (appLifecycles != null && appLifecycles.size() > 0) {
      for (IAppLifecycle appLifecycle : appLifecycles) {
        appLifecycle.onTerminate(application);
      }
    }
    if (liferecycleCallbacks != null && liferecycleCallbacks.size() > 0) {
      for (Application.ActivityLifecycleCallbacks lifecycleCallbacks : liferecycleCallbacks) {
        application.unregisterActivityLifecycleCallbacks(lifecycleCallbacks);
      }
    }
  }
}
