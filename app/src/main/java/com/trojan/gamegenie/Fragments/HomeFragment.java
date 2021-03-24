package com.trojan.gamegenie.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.trojan.gamegenie.OtherFragments.LuckySpin;
import com.trojan.gamegenie.OtherFragments.RedeemRewards;
import com.trojan.gamegenie.OtherFragments.ReferNEarn;
import com.trojan.gamegenie.OtherFragments.ShareNEarn;
import com.trojan.gamegenie.R;

public class HomeFragment extends Fragment {
    Button playButton, surveyButton;
    TextView toolbartitle, tvUsername, tvPoints;
    Context mctx;
    LinearLayout llreferandearn, llluckyspin, llshareandear, llredeem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final Toolbar toolbarid = getActivity().findViewById(R.id.toolbarid);
        toolbarid.setVisibility(View.VISIBLE);

        toolbartitle = getActivity().findViewById(R.id.toolbar_title);
        toolbartitle.setText(R.string.dashboard);

        final Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);

        playButton = view.findViewById(R.id.playButton);
        surveyButton = view.findViewById(R.id.surveyButton);
        llluckyspin = view.findViewById(R.id.llluckyspin);
        llredeem = view.findViewById(R.id.llredeem);
        llreferandearn = view.findViewById(R.id.llreferandear);
        llshareandear = view.findViewById(R.id.llshareandearn);
        tvUsername = view.findViewById(R.id.tvUsername);
        tvPoints = view.findViewById(R.id.tvPoints);


        playButton.startAnimation(myAnim);
        surveyButton.startAnimation(myAnim);

        llreferandearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbartitle = getActivity().findViewById(R.id.toolbar_title);
                toolbartitle.setText("Refer and Earn");
                getFragmentManager().beginTransaction().replace(R.id.container, new ReferNEarn()).addToBackStack(null).commit();
            }
        });


        llluckyspin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbartitle = getActivity().findViewById(R.id.toolbar_title);
                toolbartitle.setText("Lucky Spin");
                getFragmentManager().beginTransaction().replace(R.id.container, new LuckySpin()).addToBackStack(null).commit();
            }
        });

        llshareandear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbartitle = getActivity().findViewById(R.id.toolbar_title);
                toolbartitle.setText("Share App");
                getFragmentManager().beginTransaction().replace(R.id.container, new ShareNEarn()).addToBackStack(null).commit();
            }
        });

        llredeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbartitle = getActivity().findViewById(R.id.toolbar_title);
                toolbartitle.setText("My Rewards");
                getFragmentManager().beginTransaction().replace(R.id.container, new RedeemRewards()).addToBackStack(null).commit();
            }
        });


        tvUsername.setText("Welcome, Rohit Kumar");
        tvPoints.setText("50 Pts");

        return view;
    }
}
