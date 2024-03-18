package com.example.gsb;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GSBServices {
    @GET("api/motif")
    Call<Motif> getMotifs();

    @POST("api/auth/login")
    Call<Visiteur> login(@Body Visiteur visiteur);


}
