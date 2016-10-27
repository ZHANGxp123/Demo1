package com.ress.demo1;

import android.app.Application;

import com.apkplug.trust.PlugManager;

import org.apkplug.app.FrameworkFactory;

/**
 * Created by ress on 2016/10/26.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            PlugManager.getInstance().init(this, FrameworkFactory.getInstance().start(null, this).getSystemBundleContext(), "MIGdMA0GCSqGSIb3DQEBAQUAA4GLADCBhwKBgQCnO1liAe9uVCB46f7AJhaAWIKJyPgISQBjTwG/DdJ0YZHt3ekmvFg7iirj5/mRR8n6LNPxPhUBc+4hbm2S8ANoa7dC/Zt0SdanUGmSSRkv1OF+3jJ3/4hPNj2BYViEcYysWxiepftE70U9R29/Xk3IusuAn8dtF1jEO8eAfjCPVQIBAw==");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
