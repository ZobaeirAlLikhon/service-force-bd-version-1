package com.example.serviceforcebd.rest;

import com.example.serviceforcebd.model.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ServiceEndPoints {

    @GET()
    Call<List<Service>> getServices(@Url String url);
}
