package com.oakraw.testmimicproject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by oakraw on 11/23/2016 AD.
 */

public class LoginResponse {

    /**
     * isConnectDBSuccess : true
     * status : false
     * errmsg : ["The email you have entered does not match any account"]
     */

    public boolean isConnectDBSuccess;
    public boolean status;
    public List<String> errmsg;
    public Userdata userdata;

    public static class Userdata {

        public String ideplsuser;
        public String username;
        public String password;
        @SerializedName("gender-eplsuser")
        public String genderEplsuser;
        @SerializedName("phone-eplsuser")
        public String phoneEplsuser;
        @SerializedName("emerphone-eplsuser")
        public String emerphoneEplsuser;
        @SerializedName("lathome-eplsuser")
        public String lathomeEplsuser;
        @SerializedName("lnghome-eplsuser")
        public String lnghomeEplsuser;
        @SerializedName("address-eplsuser")
        public String addressEplsuser;
        @SerializedName("dob-eplsuser")
        public String dobEplsuser;
        @SerializedName("firstname-eplsuser")
        public String firstnameEplsuser;
        @SerializedName("lastname-eplsuser")
        public String lastnameEplsuser;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder()
                .append("isConnectDBSuccess : " + isConnectDBSuccess + "\n")
                .append("status : " + status + "\n");

        if (errmsg != null && errmsg.size() > 0) {
            string.append(errmsg.get(errmsg.size() - 1));
        }
        return string.toString();
    }



}
