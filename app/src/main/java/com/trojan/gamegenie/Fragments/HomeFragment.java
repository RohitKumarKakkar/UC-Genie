package com.trojan.gamegenie.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.trojan.gamegenie.R;

public class HomeFragment extends Fragment {
    Button adBtn, checkinBtn,referbtn,surveyBtn;
    private RewardedVideoAd rewardedVideoAd;
    Context mctx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        MobileAds.initialize(getContext(), "ca-app-pub-4761500786576152~8215465788");
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getContext());
        rewardedVideoAd.setRewardedVideoAdListener(rewardedVideoAdListener);


        final Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);

        adBtn = v.findViewById(R.id.playButton);
        checkinBtn = v.findViewById(R.id.checkinButton);
        referbtn = v.findViewById(R.id.refButton);
        surveyBtn = v.findViewById(R.id.surveyButton);

        adBtn.startAnimation(myAnim);
        checkinBtn.startAnimation(myAnim);
        referbtn.startAnimation(myAnim);
        surveyBtn.startAnimation(myAnim);


        adBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadRewardedVideoAd();
            }
        });

        return v;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    RewardedVideoAdListener rewardedVideoAdListener = new RewardedVideoAdListener() {
        @Override
        public void onRewardedVideoAdLoaded() {
            Toast.makeText(getActivity(), "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRewardedVideoAdOpened() {
            Toast.makeText(getActivity(), "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRewardedVideoStarted() {
            Toast.makeText(getActivity(), "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRewardedVideoAdClosed() {
            Toast.makeText(getActivity(), "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
            ////// UpdateDataBase
        }

        @Override
        public void onRewarded(RewardItem reward) {
            Toast.makeText(getActivity(),   "Success" + reward.getAmount() + " " + reward.getType(), Toast.LENGTH_LONG).show();
            // Reward the user.
        }

        @Override
        public void onRewardedVideoAdLeftApplication() {
            Toast.makeText(getActivity(), "onRewardedVideoAdLeftApplication", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRewardedVideoAdFailedToLoad(int i) {
            Toast.makeText(getActivity(), "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRewardedVideoCompleted() {

        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    };

    private void loadRewardedVideoAd(){
        AdRequest request = new AdRequest.Builder().build();
        rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", request);
        if (rewardedVideoAd.isLoaded()) {
            rewardedVideoAd.show();
        }
    }
}
