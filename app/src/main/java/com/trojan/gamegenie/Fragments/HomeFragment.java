package com.trojan.gamegenie.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.trojan.gamegenie.R;

public class HomeFragment extends Fragment {
    Button adBtn, checkinBtn, referbtn, surveyBtn;
    private RewardedVideoAd rewardedVideoAd;
    TextView toolbartitle;
    Context mctx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        final Toolbar toolbarid = getActivity().findViewById(R.id.toolbarid);
        toolbarid.setVisibility(View.VISIBLE);

        toolbartitle = getActivity().findViewById(R.id.toolbar_title);
        toolbartitle.setText("Dashboard");

        final Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);

        adBtn = v.findViewById(R.id.playButton);
        /*checkinBtn = v.findViewById(R.id.checkinButton);
        referbtn = v.findViewById(R.id.refButton);*/
        surveyBtn = v.findViewById(R.id.surveyButton);

        adBtn.startAnimation(myAnim);
       /* checkinBtn.startAnimation(myAnim);
        referbtn.startAnimation(myAnim);*/
        surveyBtn.startAnimation(myAnim);

        return v;
    }
}
