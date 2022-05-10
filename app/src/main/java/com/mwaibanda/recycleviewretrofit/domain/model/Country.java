package com.mwaibanda.recycleviewretrofit.domain.model;

import java.util.List;

public final class Country {
    final private String iso2;
    final private String iso3;
    final private String country;
    final private List<String> cities;


    public Country(String iso2, String iso3, String country, List<String> cities) {
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.country = country;
        this.cities = cities;
    }

    public String getIso2() {
        return iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getCities() {
        return cities;
    }
}

