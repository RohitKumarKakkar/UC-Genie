package com.trojan.gamegenie.PagerFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trojan.gamegenie.R;

public class RedeemHistory extends Fragment {

    public static RedeemHistory getInstance(){
        RedeemHistory redeemHistory = new RedeemHistory();
        return redeemHistory;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rewards_history, container, false);
        return view;
    }
}