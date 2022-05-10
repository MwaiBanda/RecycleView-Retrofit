package com.mwaibanda.recycleviewretrofit.domain.model;

import java.util.List;

public final class CountryResponse {
    final private boolean error;
    final private  String msg;
    final private List<Country> data;

    public CountryResponse(boolean error, String msg, List<Country> data) {
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public String getMsg() {
        return msg;
    }

    public List<Country> getData() {
        return data;
    }
}
