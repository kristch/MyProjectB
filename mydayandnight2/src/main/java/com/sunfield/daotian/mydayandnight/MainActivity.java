package com.sunfield.daotian.mydayandnight;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Toast;
//TODO 说明
/**
 * 23.2.0有一个Theme.Appcompat.daynight主题
 * 这个主题可以根据系统时间切换 Theme.AppCompat(暗色) 和 Theme.AppCompat.Light(亮色) 两种主题
 * 需要注意的是，这个特性只支持 API v14 及以上的 Android 设备，在 API v14 以下的设备则会默认使用亮色的主题。
 *
 * MODE_NIGHT_NO. 使用亮色（light）主题
 MODE_NIGHT_YES. 使用暗色（dark）主题
 MODE_NIGHT_AUTO. 根据当前时间自动切换 亮色（light）/暗色（dark）主题
 MODE_NIGHT_FOLLOW_SYSTEM(默认选项). 设置为跟随系统，通常为 MODE_NIGHT_NO
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  if (savedInstanceState == null) {
            // Set the local night mode to some value
            getDelegate().setLocalNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
            recreate();
        }*/
        getDelegate().setLocalNightMode(
                AppCompatDelegate.MODE_NIGHT_AUTO);
        recreate();
        setContentView(R.layout.activity_main);

        //initMode();
    }

    private void initMode() {
        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                // Night mode is not active, we're in day time
                Toast.makeText(this,"白天",Toast.LENGTH_SHORT).show();
            case Configuration.UI_MODE_NIGHT_YES:
                // Night mode is active, we're at night!
                Toast.makeText(this,"夜晚",Toast.LENGTH_SHORT).show();
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                // We don't know what mode we're in, assume notnight
                Toast.makeText(this,"没设置",Toast.LENGTH_SHORT).show();
        }
    }

}
