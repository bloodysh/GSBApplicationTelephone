package com.example.gsb;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GSBServices {
    @GET("api/motif")
    Call<Motif> getMotifs();

    @POST("api/auth/login")
    Call<Visiteur> login(@Body Visiteur visiteur);

    @GET("api/visiteur/{id}")
    Call<Visiteur> getVisiteur(@Header("Authorization") String authorization, @Path("id") String id);

    @GET("api/praticien")
    Call<ArrayList<Praticien>> getPraticiens(@Header("Authorization") String authorization);

    @GET("api/visite")
    Call<ArrayList<Visite>> getVisites(@Header("Authorization") String authorization);
}
