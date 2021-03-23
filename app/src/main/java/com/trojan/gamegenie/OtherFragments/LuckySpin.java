package com.trojan.gamegenie.OtherFragments;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;
import com.trojan.gamegenie.MainActivity;
import com.trojan.gamegenie.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LuckySpin extends Fragment {

    private LuckyWheel lw;
    List<WheelItem> wheelItems;
    Button start, claim;
    int random;
    int position;
    final int min = 1;
    final int max = 6;
    ImageView gobackicon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lucky_spin, container, false);

        generateWheelItems();
        final Toolbar toolbarid = getActivity().findViewById(R.id.toolbarid);
        toolbarid.setVisibility(View.GONE);

        lw = view.findViewById(R.id.lwv);
        lw.addWheelItems(wheelItems);
        lw.setTarget(1);


        lw.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                if (position == 1) {
                    Toast.makeText(getContext(), "position 1", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Toast.makeText(getContext(), "position 2", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    Toast.makeText(getContext(), "position 3", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    Toast.makeText(getContext(), "position 4", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Toast.makeText(getContext(), "position 5", Toast.LENGTH_SHORT).show();
                } else if (position == 6) {
                    Toast.makeText(getContext(), "position 6", Toast.LENGTH_SHORT).show();
                }
                start.setVisibility(View.GONE);
                claim.setVisibility(View.VISIBLE);
            }
        });

        start = view.findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random = new Random().nextInt((max - min) + 1) + min;
                position = random;
                lw.rotateWheelTo(position);
                start.setVisibility(View.INVISIBLE);
            }
        });

        claim = view.findViewById(R.id.claim);
        claim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Play Ad", Toast.LENGTH_SHORT).show();
            }
        });

        gobackicon = view.findViewById(R.id.gobackIconn);
        gobackicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                getActivity().finish();
                startActivity(intent);
            }
        });

        return view;
    }

    private void generateWheelItems() {
        wheelItems = new ArrayList<>();
        wheelItems.add(new WheelItem(Color.parseColor("#1a213d"), BitmapFactory.decodeResource(getResources(),
                R.drawable.coin), "0 5   G  P"));
        wheelItems.add(new WheelItem(Color.parseColor("#3c4c89"), BitmapFactory.decodeResource(getResources(),
                R.drawable.coin), "1 0   G  P"));
        wheelItems.add(new WheelItem(Color.parseColor("#1a213d"), BitmapFactory.decodeResource(getResources(),
                R.drawable.coin), "1 5   G  P"));
        wheelItems.add(new WheelItem(Color.parseColor("#3c4c89"), BitmapFactory.decodeResource(getResources(),
                R.drawable.coin), "2 0   G  P"));
        wheelItems.add(new WheelItem(Color.parseColor("#1a213d"), BitmapFactory.decodeResource(getResources(),
                R.drawable.coin), "2 5   G  P"));
        wheelItems.add(new WheelItem(Color.parseColor("#3c4c89"), BitmapFactory.decodeResource(getResources(),
                R.drawable.coin), "3 0   G  P"));
    }
}