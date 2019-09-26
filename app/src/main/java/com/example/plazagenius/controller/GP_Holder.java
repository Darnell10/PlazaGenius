package com.example.plazagenius.controller;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plazagenius.R;
import com.example.plazagenius.models.Data;
import com.squareup.picasso.Picasso;


public class GP_Holder extends RecyclerView.ViewHolder {


    ImageView userImage;


    TextView userName;


    public GP_Holder(@NonNull View itemView) {
        super(itemView);


        userName = itemView.findViewById(R.id.gp_name);

        userImage = itemView.findViewById(R.id.gp_image);


    }

    public void onBind(Data data) {

        userName.setText(data.combineName());

        Picasso.with(itemView.getContext())
                .load(data.getAvatar())
                .placeholder(R.drawable.genius_plaza_bulb)
                .error(R.drawable.genius_plaza_bulb)
                .into(userImage);
    }
}
