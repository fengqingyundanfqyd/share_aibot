package com.example.aiqing.sharerobot.inf;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


public class RetroFactory {

    private static String baseUrl = "http://192.168.1.150:8083/";

    private static Retrofit jsonRetrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static Retrofit stringRetrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static RetrofitService getJsonService() {
        RetrofitService service = jsonRetrofit.create(RetrofitService.class);
        return service;
    }

    public static RetrofitService getStringService() {
        RetrofitService service = stringRetrofit.create(RetrofitService.class);
        return service;
    }
}
