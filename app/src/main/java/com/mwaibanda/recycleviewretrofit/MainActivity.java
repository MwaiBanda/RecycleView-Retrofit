package com.mwaibanda.recycleviewretrofit;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mwaibanda.recycleviewretrofit.data.CountryListAdapter;
import com.mwaibanda.recycleviewretrofit.di.ApplicationComponent;
import com.mwaibanda.recycleviewretrofit.di.DaggerApplicationComponent;
import com.mwaibanda.recycleviewretrofit.domain.model.Country;
import com.mwaibanda.recycleviewretrofit.utils.EqualSpacingItemDecoration;
import com.mwaibanda.recycleviewretrofit.utils.CountryClickListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    MainViewModel mainViewModel;
    CountryListAdapter adapter;
    RecyclerView recyclerView;
    CountryClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationComponent applicationComponent = DaggerApplicationComponent.create();
        applicationComponent.inject(this);

        List<Country> countries = new ArrayList<>();
        mainViewModel.countries().observe(this, newCountries -> {
            countries.clear();
            countries.addAll(newCountries);
            adapter.notifyDataSetChanged();
        });

        recyclerView = findViewById(R.id.recyclerView);
        listener = new CountryClickListener() {
            @Override
            public void onClick(int index) {
                Toast.makeText(MainActivity.this, "Clicked" + countries.get(index).getCountry(), Toast.LENGTH_SHORT).show();
            }
        };
        adapter = new CountryListAdapter(countries, this, listener);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new EqualSpacingItemDecoration(30, EqualSpacingItemDecoration.DisplayMode.VERTICAL));
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}