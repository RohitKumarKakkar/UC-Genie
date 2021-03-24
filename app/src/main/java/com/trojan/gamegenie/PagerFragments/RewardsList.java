package com.trojan.gamegenie.PagerFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trojan.gamegenie.R;

public class RewardsList extends Fragment {

    public static RewardsList getInstance() {
        RewardsList rewardsList = new RewardsList();
        return rewardsList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rewards_list, container, false);
        return view;
    }
}