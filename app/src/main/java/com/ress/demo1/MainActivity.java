package com.ress.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.apkplug.trust.PlugManager;
import com.apkplug.trust.common.listeners.OnInstallListener;
import com.apkplug.trust.data.PlugInfo;

public class MainActivity extends AppCompatActivity {

    org.osgi.framework.Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_install = (Button) findViewById(R.id.btn_install);
        btn_install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlugManager.getInstance().installAssets(MainActivity.this, "app-debug.apk", "1.0.0", new OnInstallListener() {
                    @Override
                    public void onDownloadProgress(String s, String s1, long l, long l1, PlugInfo plugInfo) {
                        Toast.makeText(MainActivity.this, "正在下载"+"l/l1", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onInstallSuccess(org.osgi.framework.Bundle bundle, PlugInfo plugInfo) {
                        mBundle = bundle;
                    }

                    @Override
                    public void onInstallFailuer(int i, PlugInfo plugInfo, String s) {
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDownloadFailure(String s) {
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btn_run = (Button) findViewById(R.id.btn_run);
        btn_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if (mBundle.getState() != mBundle.ACTIVE) {
                    try {
                        mBundle.start();
                    } catch (BundleException e) {
                        e.printStackTrace();
                    }
                }*/

                if (mBundle.getBundleActivity() != null) {
                    Intent intent = new Intent();
                    intent.setClassName(MainActivity.this, "com.ress.plugin.activity.MainActivity");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("gg", "hghghghghgh");
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "没有配置", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
