package com.example.gsb;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface GSBServices {
    @GET("api/motif")
    Call<Motif> getMotifs();

    @GET("api/login")
    Call<Visiteur> login();


}
