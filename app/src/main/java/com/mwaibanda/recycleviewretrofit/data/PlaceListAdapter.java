package com.mwaibanda.recycleviewretrofit.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mwaibanda.recycleviewretrofit.R;
import com.mwaibanda.recycleviewretrofit.model.Place;
import com.mwaibanda.recycleviewretrofit.utils.PlaceClickListener;

import java.util.Collections;
import java.util.List;

public class PlaceListAdapter extends RecyclerView.Adapter<PlaceViewHolder> {
    List<Place> places = Collections.emptyList();
    Context context;
    PlaceClickListener listener;

    public PlaceListAdapter(List<Place> places, Context context, PlaceClickListener listener){
        this.places = places;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View cardView = inflater.inflate(R.layout.card_layout, parent, false);
        PlaceViewHolder placeViewHolder = new PlaceViewHolder(cardView);
        return placeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
            final int index = holder.getAdapterPosition();
            String country  = places.get(position).getCountry();
        String city  = places.get(position).getCity();

        holder.country.setText(country);
        holder.city.setText(city);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
