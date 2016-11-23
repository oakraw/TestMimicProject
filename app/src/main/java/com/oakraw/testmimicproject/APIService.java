package com.oakraw.testmimicproject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oakraw on 11/23/2016 AD.
 */

public class APIService {

    private static final String BASE_URL = "http://54.179.158.109";
    private final Endpoint endpoint;

    public APIService() {
        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        endpoint = retrofit.create(Endpoint.class);
    }

    public void login(String username, String password, Callback<LoginResponse> callback){
        endpoint.login(new LoginRequest(username, password)).enqueue(callback);
    }
}
