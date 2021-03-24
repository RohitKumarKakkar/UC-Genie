package com.trojan.gamegenie.OnboardViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.trojan.gamegenie.R;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.video_vector,
            R.drawable.refer_one,
            R.drawable.ic_spin,
            R.drawable.rewards
    };

    public String[] header = {
            "Watch Videos & Earn",
            "Refer & Earn",
            "Spin The Wheel",
            "Redeem Best Rewards"
    };

    public String[] detail = {
            "Watch Videos and Earn GP Point and Redeem for exciting Rewards",
            "Refer your friends and Earn GP",
            "Test your luck and Win Jackpot every 6 Hours",
            "Best Rewards According to your preferences, Lets Dig in and Earn Rerwards"
    };

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageView = view.findViewById(R.id.pagerIV);
        TextView pagertv1 = view.findViewById(R.id.pagerTV);
        TextView pagertv2 = view.findViewById(R.id.pagerTV2);

        imageView.setImageResource(slide_images[position]);
        pagertv1.setText(header[position]);
        pagertv2.setText(detail[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
