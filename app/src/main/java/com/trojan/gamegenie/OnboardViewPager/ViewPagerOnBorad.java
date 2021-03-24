package com.trojan.gamegenie.OnboardViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.trojan.gamegenie.LoginScreen;
import com.trojan.gamegenie.R;


public class ViewPagerOnBorad extends AppCompatActivity {

    ViewPager ViewpagerID;
    LinearLayout mDotsLayout;

    Button buttonNext, buttonPrev;
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private int mCurrenPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_on_borad);

        buttonNext = findViewById(R.id.buttonNext);
        buttonPrev = findViewById(R.id.buttonPrev);
        ViewpagerID = findViewById(R.id.ViewpagerID);
        mDotsLayout = findViewById(R.id.mDotsLayout);
        buttonNext.setVisibility(View.GONE);

        sliderAdapter = new SliderAdapter(this);
        ViewpagerID.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        ViewpagerID.addOnPageChangeListener(viewListener);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewpagerID.setCurrentItem(mCurrenPage + 1);
            }
        });

        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewpagerID.setCurrentItem(mCurrenPage - 1);
            }
        });


    }

    private void addDotsIndicator(int position) {

        mDots = new TextView[4];
        mDotsLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorBlack));

            mDotsLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }


    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int state, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrenPage = position;


            if (position == 0) {
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(false);
                buttonPrev.setVisibility(View.INVISIBLE);
                buttonNext.setText("Next");
                buttonPrev.setText("");
                buttonNext.setVisibility(View.GONE);
            } else if (position == mDots.length - 1) {
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(true);
                buttonPrev.setVisibility(View.VISIBLE);
                buttonNext.setText("Finish");
                buttonPrev.setText("Back");
                buttonNext.setVisibility(View.VISIBLE);
                buttonNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ViewPagerOnBorad.this, LoginScreen.class);
                        startActivity(intent);
                        finish();
                    }
                });
            } else {

                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(true);
                buttonPrev.setVisibility(View.VISIBLE);
                buttonNext.setVisibility(View.GONE);
                buttonNext.setText("Next");
                buttonPrev.setText("Back");

            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {


        }
    };

}