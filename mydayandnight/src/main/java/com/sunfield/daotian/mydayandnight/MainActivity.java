package com.sunfield.daotian.mydayandnight;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static boolean blFlag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("default_night", MODE_PRIVATE);
        blFlag = preferences.getBoolean("default_night",true);
        if (blFlag) {
            this.setTheme(R.style.BrowserThemeDefault);
        }
        else {
            this.setTheme(R.style.BrowserThemeNight);
        }

        setContentView(R.layout.activity_main);
    }

    public void btonclick(View view) {
        SharedPreferences preferences = getSharedPreferences("default_night",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (blFlag) {
            this.setTheme(R.style.BrowserThemeNight);
            blFlag =false;
            editor.putBoolean("default_night",false);
        } else {
            this.setTheme(R.style.BrowserThemeDefault);
            blFlag = true;
            editor.putBoolean("default_night",true);

        }
        // 提交修改
        editor.commit();
        this.setContentView(R.layout.activity_main);
    }

    public void btonclick2(View view) {
        Intent intent = new Intent();
        intent.setClass(this, blackActivity.class);
        startActivity(intent);
    }


}
