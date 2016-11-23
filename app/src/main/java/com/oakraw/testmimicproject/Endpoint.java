package com.oakraw.testmimicproject;

import android.provider.SyncStateContract;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by oakraw on 11/23/2016 AD.
 */

public interface Endpoint {
   /* @POST("datatrafficarrangement/login/ambulance/login.php")
    Call<LoginResponse> login(@Body LoginRequest request);*/
    @Multipart
    @POST("datatrafficarrangement/login/ambulance/login.php")
    Call<LoginResponse> login(@Part("username") RequestBody username, @Part("password") RequestBody password);
}
