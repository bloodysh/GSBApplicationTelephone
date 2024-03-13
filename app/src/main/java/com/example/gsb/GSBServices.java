package com.example.gsb;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GSBServices {
    @GET("api/motif")
    Call<Motif> getMotifs();


}
