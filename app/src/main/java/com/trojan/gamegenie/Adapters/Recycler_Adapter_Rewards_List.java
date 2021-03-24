package com.trojan.gamegenie.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.trojan.gamegenie.R;

public class Recycler_Adapter_Rewards_List extends RecyclerView.Adapter<Recycler_Adapter_Rewards_List.ProductViewHolder> {
    private final Context mCtx;
    Dialog dialog;
    // private List<OrganicProducts> products;


    public Recycler_Adapter_Rewards_List(Context context /*,List<OrganicProducts> products,*/) {
        this.mCtx = context;
        /*  this.products = products;*/
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        private final TextView rewardTitle;
        private final TextView redeemBtn;
        private final TextView requiredCoins;
        private final ImageView rewardImage;


        public ProductViewHolder(View itemView) {
            super(itemView);
            rewardImage = itemView.findViewById(R.id.rewardImage);
            rewardTitle = itemView.findViewById(R.id.rewardTitle);
            requiredCoins = itemView.findViewById(R.id.requiredCoins);
            redeemBtn = itemView.findViewById(R.id.redeemBtn);

        }

    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.singelton_reward_list, parent, false);
        final ProductViewHolder vHolder = new ProductViewHolder(view);


        dialog = new Dialog(mCtx);
        dialog.setContentView(R.layout.dialog_redeem);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {

        /* final OrganicProducts product = products.get(position);S*/
        String url = "";

        Glide.with(mCtx).load(R.drawable.ic_uc).into(holder.rewardImage);

        holder.rewardTitle.setText("Pubg Mobile UC (Global)");
        holder.requiredCoins.setText("600 GP = 60 UC");


        holder.redeemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView rewardTitle, requiredCoins, redeemBtn;
                final EditText edtCharId;
                ImageView rewardImage;

                String ordername, coinsspent;

                rewardTitle = dialog.findViewById(R.id.rewardTitle);
                requiredCoins = dialog.findViewById(R.id.requiredCoins);
                redeemBtn = dialog.findViewById(R.id.redeemBtn);
                edtCharId = dialog.findViewById(R.id.edtcharID);
                rewardImage = dialog.findViewById(R.id.rewardImage);

                redeemBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!edtCharId.getText().toString().equals("")) {
                            String charid = edtCharId.getText().toString();
                            Toast.makeText(mCtx, "Order Placed", Toast.LENGTH_SHORT).show();
                            dialog.hide();
                        } else {
                            Toast.makeText(mCtx, "Please Enter Game Characted ID", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 1;
    }

}
