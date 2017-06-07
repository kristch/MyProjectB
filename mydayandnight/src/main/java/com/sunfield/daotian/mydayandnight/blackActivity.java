package com.sunfield.daotian.mydayandnight;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017-06-07 .
 */

public class blackActivity extends AppCompatActivity {
    private static boolean blFlag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences("default_night",
                MODE_PRIVATE);
        blFlag = preferences.getBoolean("default_night",true);
        if (blFlag) {
            this.setTheme(R.style.BrowserThemeDefault);
        }
        else {
            this.setTheme(R.style.BrowserThemeNight);
        }
        setContentView(R.layout.activity2);
    }
}