package com.mwaibanda.recycleviewretrofit.data.remote;

import com.mwaibanda.recycleviewretrofit.domain.model.CountryResponse;
import com.mwaibanda.recycleviewretrofit.domain.repository.CountryRepository;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public final class CountryRepositoryImpl implements CountryRepository {
    final private CountryService service;

    @Inject public CountryRepositoryImpl(CountryService service) {
        this.service = service;
    }

    @Override
    public void fetchCountries(FetchResult completion) {
        Call<CountryResponse> call = service.getCountries();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<CountryResponse> response = call.execute();
                    completion.onSuccess(response.body().getData());
                } catch (Exception e) {
                    completion.onFailure(e);
                }
            }
        });
        thread.start();
    }
}
