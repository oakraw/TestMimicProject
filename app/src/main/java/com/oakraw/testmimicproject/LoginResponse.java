package com.oakraw.testmimicproject;

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

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder()
                .append("isConnectDBSuccess : " + isConnectDBSuccess + "\n")
                .append("status : " + status + "\n");

        if(errmsg != null && errmsg.size() > 0){
            string.append(errmsg.get(errmsg.size() - 1));
        }
        return string.toString();
    }
}
