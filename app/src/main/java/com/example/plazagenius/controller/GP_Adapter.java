package com.example.plazagenius.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plazagenius.R;
import com.example.plazagenius.models.Data;

import java.util.List;

public class GP_Adapter extends RecyclerView.Adapter<GP_Holder> {
    private List<Data> dataList;

    public GP_Adapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public GP_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout, viewGroup, false);

        return new GP_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GP_Holder gp_holder, int i) {

        gp_holder.onBind(dataList.get(i));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
