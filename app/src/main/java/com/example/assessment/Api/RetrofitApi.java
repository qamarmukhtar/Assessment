package com.example.assessment.Api;


import com.example.assessment.Module.NewsModule;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RetrofitApi {



    @GET("everything")
    Call<NewsModule> Recentlyjob(
            @Query("q") String q,
            @Query("apiKey") String apiKey);

}
