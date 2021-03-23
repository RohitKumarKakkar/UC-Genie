package com.trojan.gamegenie.OtherFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.trojan.gamegenie.MainActivity;
import com.trojan.gamegenie.R;


public class ReferNEarn extends Fragment {
    CardView refercard, promocard;
    TextView entercodetv, promocodetv;
    ImageView GobackIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_refer_n_earn, container, false);

        refercard = view.findViewById(R.id.refercard);
        promocard = view.findViewById(R.id.promocard);
        entercodetv = view.findViewById(R.id.enterCodetv);
        promocodetv = view.findViewById(R.id.promoCodetv);
        GobackIcon = view.findViewById(R.id.GoBackIcon);
        GobackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                getActivity().finish();
                startActivity(intent);
            }
        });


        entercodetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refercard.setVisibility(View.GONE);
                promocard.setVisibility(View.VISIBLE);
            }
        });

        promocodetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refercard.setVisibility(View.VISIBLE);
                promocard.setVisibility(View.GONE);
            }
        });


        return view;
    }
}