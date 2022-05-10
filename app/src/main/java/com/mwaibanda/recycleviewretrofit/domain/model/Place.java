package com.mwaibanda.recycleviewretrofit.domain.model;

public final class Place {
    final String  country;
    final String city;

    public Place(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry(){
        return country;
    }
    public String getCity(){
        return city;
    }

}
