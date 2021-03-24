package com.trojan.gamegenie.OtherFragments;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.trojan.gamegenie.PagerFragments.RedeemHistory;
import com.trojan.gamegenie.PagerFragments.RewardsList;
import com.trojan.gamegenie.PagerFragments.ViewPagerAdapter;
import com.trojan.gamegenie.R;

public class RedeemRewards extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_redeem_rewards, container, false);

        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewPager);
        loadViewPager();

        return view;
    }

    public void loadViewPager() {
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                viewPagerAdapter.addFragment(RewardsList.getInstance(), "Rewards");
                viewPagerAdapter.addFragment(RedeemHistory.getInstance(), "History");
                viewPager.setAdapter(viewPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);


            }
        });
    }
}