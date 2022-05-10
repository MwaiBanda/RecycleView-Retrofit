package com.mwaibanda.recycleviewretrofit.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mwaibanda.recycleviewretrofit.R;
import com.mwaibanda.recycleviewretrofit.domain.model.Country;
import com.mwaibanda.recycleviewretrofit.utils.CountryClickListener;

import java.util.Collections;
import java.util.List;

public final class CountryListAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    List<Country> places = Collections.emptyList();
    Context context;
    CountryClickListener listener;

    public CountryListAdapter(List<Country> places, Context context, CountryClickListener listener){
        this.places = places;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View cardView = inflater.inflate(R.layout.card_layout, parent, false);
        CountryViewHolder countryViewHolder = new CountryViewHolder(cardView);
        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
            final int index = holder.getAdapterPosition();
            String country  = places.get(position).getCountry();
        String city  = places.get(position).getCities().get(0);

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
