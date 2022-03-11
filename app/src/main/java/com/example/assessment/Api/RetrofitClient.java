package com.example.assessment.Api;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    public static final String BASE_URL="https://newsapi.org/v2/";
    Retrofit retrofit;
    private static RetrofitClient instance;

    public RetrofitClient() {
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
        retrofit=new Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create(gson)).
                client(okHttpClient).
                build();
    }
    public static synchronized RetrofitClient getInstance()
    {
        if(instance==null)
        {
            instance=new RetrofitClient();
        }
        return instance;
    }
    public RetrofitApi getApi()
    {
        return retrofit.create(RetrofitApi.class);
    }


}
