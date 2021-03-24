package com.trojan.gamegenie.PagerFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trojan.gamegenie.Adapters.Recycler_Adapter_Rewards_List;
import com.trojan.gamegenie.R;

public class RewardsList extends Fragment {

    public static RewardsList getInstance() {
        RewardsList rewardsList = new RewardsList();
        return rewardsList;
    }

    RecyclerView recyclerView;
    private Recycler_Adapter_Rewards_List mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rewards_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        mAdapter = new Recycler_Adapter_Rewards_List(getContext());
        recyclerView.setAdapter(mAdapter);

        return view;
    }


}