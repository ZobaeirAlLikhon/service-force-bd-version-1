package com.sfbd.serviceforcebd.rest;

import com.sfbd.serviceforcebd.model.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ServiceEndPoints {

    @GET()
    Call<List<Service>> getServices(@Url String url);
}
