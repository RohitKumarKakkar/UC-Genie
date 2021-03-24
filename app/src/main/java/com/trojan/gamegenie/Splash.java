package com.trojan.gamegenie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import com.trojan.gamegenie.OnboardViewPager.ViewPagerOnBorad;

public class Splash extends AppCompatActivity {
    Handler handler;
    ImageView imageView;
    RelativeLayout mainllsplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.mainlogo);
        mainllsplash = findViewById(R.id.mainllsplash);
        mainllsplash.setBackgroundColor(Color.parseColor("#FFFFFF"));


        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (haveNetwork()) {

                    if (helpingforwalklayout()) {
                        Intent intent = new Intent(Splash.this, ViewPagerOnBorad.class);
                        startActivity(intent);
                        finish();

                    } else {

                        Intent intent = new Intent(Splash.this, LoginScreen.class);
                        startActivity(intent);
                        finish();

                    }

                } else if (!haveNetwork()) {

                    Intent intent = new Intent(Splash.this, NoInternet.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 3700);


    }


    private boolean haveNetwork() {
        boolean haveWiFi = false;
        boolean haveMobileData = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = cm.getAllNetworkInfo();

        for (NetworkInfo info : networkInfos) {
            if (info.getTypeName().equalsIgnoreCase("WIFI")) {
                if (info.isConnected())
                    haveWiFi = true;
            }
            if (info.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (info.isConnected())
                    haveMobileData = true;
            }

        }
        return haveMobileData | haveWiFi;
    }


    private boolean helpingforwalklayout() {

        SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = sharedPreferences.getBoolean("firstStart", true);

        if (firstStart == true) {

            SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();
            return true;
        }

        return firstStart;
    }


}
