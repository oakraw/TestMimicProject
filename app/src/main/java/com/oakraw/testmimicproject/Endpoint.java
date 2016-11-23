package com.oakraw.testmimicproject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by oakraw on 11/23/2016 AD.
 */

public interface Endpoint {
    @POST("datatrafficarrangement/login/eplsuser/login.php")
    Call<LoginResponse> login(@Body LoginRequest request);
}
