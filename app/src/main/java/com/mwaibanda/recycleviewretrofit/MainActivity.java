package com.mwaibanda.recycleviewretrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.mwaibanda.recycleviewretrofit.data.PlaceListAdapter;
import com.mwaibanda.recycleviewretrofit.model.Place;
import com.mwaibanda.recycleviewretrofit.utils.EqualSpacingItemDecoration;
import com.mwaibanda.recycleviewretrofit.utils.PlaceClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    PlaceListAdapter adapter;
    RecyclerView recyclerView;
    PlaceClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Place> places = new ArrayList<>();
        places = getPlaces();

        recyclerView = findViewById(R.id.recyclerView);
        List<Place> finalPlaces = places;
        listener = new PlaceClickListener() {
            @Override
            public void onClick(int index) {
                Toast.makeText(MainActivity.this, "Clicked " + finalPlaces.get(index).getCountry(), Toast.LENGTH_LONG).show();
            }
        };
        adapter = new PlaceListAdapter(places, this, listener);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new EqualSpacingItemDecoration(30, 1));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private List<Place> getPlaces() {
        List<Place> places = new ArrayList<>();
        places.add(new Place("USA", "Schererville"));
        places.add(new Place("Zambia", "Lusaka"));
        places.add(new Place("USA", "Schererville"));
        places.add(new Place("Zambia", "Lusaka"));
        places.add(new Place("USA", "Schererville"));
        places.add(new Place("Zambia", "Lusaka"));
        places.add(new Place("USA", "Schererville"));
        places.add(new Place("Zambia", "Lusaka"));
        return places;
    }
}