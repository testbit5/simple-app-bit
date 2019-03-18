package com.example.restapipractice.data.network.request;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("userName")
    private String mUserName;

    @SerializedName("userPassword")
    private String mUserPassword;

    public LoginRequest(String uname, String pass){
        mUserName = uname;
        mUserPassword = pass;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getUserPassword() {
        return mUserPassword;
    }

    public void setUserPassword(String userPassword) {
        mUserPassword = userPassword;
    }
}
