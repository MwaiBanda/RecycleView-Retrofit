package com.mwaibanda.recycleviewretrofit.data.remote;


import com.mwaibanda.recycleviewretrofit.domain.model.CountryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryService {

    @GET("api/v0.1/countries/")
     Call<CountryResponse> getCountries();
}
