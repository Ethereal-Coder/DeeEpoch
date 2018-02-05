package com.syh.deeepoch.epochcore;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public final class ManifestParse {
  private static final String COMPONENT_VALUE = "IComponentConfig";
  private final Context context;

  public ManifestParse(Context context) {
    this.context = context;
  }

  public List<IComponentConfig> parse() {
    List<IComponentConfig> componentConfigs = new ArrayList<>();
    try {
      ApplicationInfo applicationInfo = context.getPackageManager()
          .getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
      if (applicationInfo.metaData != null) {
        for (String key : applicationInfo.metaData.keySet()) {
          if (COMPONENT_VALUE.equals(applicationInfo.metaData.get(key))) {
            componentConfigs.add(parseComponent(key));
          }
        }
      }
    } catch (PackageManager.NameNotFoundException e) {
      throw new RuntimeException("解析Application失败", e);
    }
    return componentConfigs;
  }

  private static IComponentConfig parseComponent(String className) {
    Class<?> clazz;
    try {
      clazz = Class.forName(className);
    } catch (ClassNotFoundException e) {
      throw new IllegalArgumentException(e);
    }

    Object component;
    try {
      component = clazz.newInstance();
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return (IComponentConfig) component;
  }
}
