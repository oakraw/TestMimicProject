package com.oakraw.testmimicproject;

/**
 * Created by oakraw on 11/23/2016 AD.
 */

public class LoginRequest {
    public String email;
    public String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
