package com.mwaibanda.recycleviewretrofit.data;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mwaibanda.recycleviewretrofit.R;

public class PlaceViewHolder extends RecyclerView.ViewHolder {
    TextView country;
    TextView city;
    View view;

    public PlaceViewHolder(@NonNull View itemView) {
        super(itemView);
        this.country = itemView.findViewById(R.id.txtCountry);
        this.city = itemView.findViewById(R.id.txtCity);
        this.view = itemView;
    }
}
