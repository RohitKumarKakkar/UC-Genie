package com.trojan.gamegenie.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.trojan.gamegenie.R;

public class Recycler_Adapter_Redeem_History extends RecyclerView.Adapter<Recycler_Adapter_Redeem_History.ProductViewHolder> {

    private final Context mCtx;

    public Recycler_Adapter_Redeem_History(Context mCtx) {
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.singleton_reward_history, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        String url = "";

        Glide.with(mCtx).load(R.drawable.ic_uc).into(holder.rewardImage);

        holder.rewardTitle.setText("Pubg Mobile UC (Global)");
        holder.orderedPoints.setText("600 GP = 60 UC");
        holder.rewardStatus.setText("Processing");
        holder.dateordered.setText("12-03-2021");

    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private final TextView rewardTitle;
        private final TextView rewardStatus;
        private final TextView orderedPoints, dateordered;
        private final ImageView rewardImage;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            rewardImage = itemView.findViewById(R.id.rewardImage);
            rewardTitle = itemView.findViewById(R.id.rewardTitle);
            orderedPoints = itemView.findViewById(R.id.orderedPoints);
            dateordered = itemView.findViewById(R.id.dateOrdered);
            rewardStatus = itemView.findViewById(R.id.rewardStatus);


        }
    }
}
