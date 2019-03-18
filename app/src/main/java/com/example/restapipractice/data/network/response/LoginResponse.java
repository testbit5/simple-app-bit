package com.example.restapipractice.data.network.response;

import com.example.restapipractice.data.model.LoginConfigInfo;
import com.google.gson.annotations.SerializedName;


public class LoginResponse extends BaseResponse{

    @SerializedName("userInfo")
    LoginConfigInfo mLoginConfigInfo = new LoginConfigInfo();

    public LoginConfigInfo getLoginConfigInfo() {
        return mLoginConfigInfo;
    }

    public void setLoginConfigInfo(LoginConfigInfo loginConfigInfo) {
        mLoginConfigInfo = loginConfigInfo;
    }
}
