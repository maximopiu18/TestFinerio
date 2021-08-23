package com.example.testfinerio.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.example.testfinerio.contans.Constants.urlBase;

public class ApiAdapter {

    private static Retrofit retrofit;
    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}