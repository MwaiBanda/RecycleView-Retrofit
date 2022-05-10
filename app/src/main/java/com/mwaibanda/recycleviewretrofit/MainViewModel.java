package com.mwaibanda.recycleviewretrofit;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mwaibanda.recycleviewretrofit.domain.model.Country;
import com.mwaibanda.recycleviewretrofit.domain.repository.CountryRepository;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {
    final private CountryRepository repository;
    MutableLiveData<List<Country>> countries;
    LiveData<List<Country>> getCountries() {
        if (countries == null){
            countries = new MutableLiveData<>();
            fetchCountries();
        }
        return countries;
    }

    @Inject public MainViewModel(CountryRepository repository) {
        this.repository = repository;
        fetchCountries();
    }


    void fetchCountries() {
        repository.fetchCountries(new CountryRepository.FetchResult() {
            @Override
            public void onSuccess(List<Country> countryData) {
                countries.postValue(countryData);
                Log.d("TAG", "Success");
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
                Log.d("TAG", "Failure");
            }
        });
    }
}
