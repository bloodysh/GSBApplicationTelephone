package com.example.gsb;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://improved-yodel-j66wpjpqxj7fj66x-3000.app.github.dev/";
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            }
            return retrofit;
        }
    }

