package com.trojan.gamegenie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;

import com.trojan.gamegenie.OnboardViewPager.ViewPagerOnBorad;

public class NoInternet extends AppCompatActivity {
    ImageView imgnoi;
    SwipeRefreshLayout swipeRefreshLayout;
    TextView noconnecttv1, noconnecttv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);

        imgnoi = findViewById(R.id.imgnoi);
        Glide.with(this).asGif().load(R.drawable.nointernetgif).into(imgnoi);
        noconnecttv1 = findViewById(R.id.noconnecttv1);
        noconnecttv2 = findViewById(R.id.noconnecttv2);
        swipeRefreshLayout = findViewById(R.id.refreshLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (haveNetwork()) {

                    if (helpwalklayout()) {

                        Intent intent = new Intent(NoInternet.this, ViewPagerOnBorad.class);
                        startActivity(intent);
                        finish();
                    } else {

                        Intent intent = new Intent(NoInternet.this, LoginScreen.class);
                        startActivity(intent);
                        finish();

                    }

                } else if (!haveNetwork()) {

                    Intent intent = new Intent(NoInternet.this, NoInternet.class);
                    startActivity(intent);
                    finish();

                }
            }
        });
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


    private boolean helpwalklayout() {

        SharedPreferences Preferences = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStartNew = Preferences.getBoolean("firstStartNew", true);

        if (firstStartNew == true) {

            SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("firstStartNew", false);
            editor.apply();
            return true;
        }

        return firstStartNew;
    }


}