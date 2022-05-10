package com.mwaibanda.recycleviewretrofit.domain.repository;


import com.mwaibanda.recycleviewretrofit.domain.model.Country;

import java.util.List;



public interface CountryRepository {
    void fetchCountries(FetchResult completion);
    interface FetchResult {
        void onSuccess(List<Country> countries);
        void onFailure(Exception e);
    }
}
