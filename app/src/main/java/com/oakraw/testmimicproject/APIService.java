package com.oakraw.testmimicproject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
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
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endpoint = retrofit.create(Endpoint.class);
    }

    public void login(String username, String password, Callback<LoginResponse> callback){
        RequestBody usernameFormData = RequestBody.create(MediaType.parse("text/plain"), username);
        RequestBody passwordFormData = RequestBody.create(MediaType.parse("text/plain"), password);

        endpoint.login(usernameFormData, passwordFormData).enqueue(callback);
    }
}
