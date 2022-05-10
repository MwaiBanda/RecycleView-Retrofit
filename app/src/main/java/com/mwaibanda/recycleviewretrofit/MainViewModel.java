package com.mwaibanda.recycleviewretrofit;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mwaibanda.recycleviewretrofit.domain.model.Country;
import com.mwaibanda.recycleviewretrofit.domain.repository.CountryRepository;

import java.util.List;

import javax.inject.Inject;

public final class MainViewModel extends ViewModel {
    final private CountryRepository repository;
    private MutableLiveData<List<Country>> _countries;
    LiveData<List<Country>> countries() {
        if (_countries == null){
            _countries = new MutableLiveData<>();
            fetchCountries();
        }
        return _countries;
    }

    @Inject public MainViewModel(CountryRepository repository) {
        this.repository = repository;
        fetchCountries();
    }


    void fetchCountries() {
        repository.fetchCountries(new CountryRepository.FetchResult() {
            @Override
            public void onSuccess(List<Country> countryData) {
                _countries.postValue(countryData);
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
