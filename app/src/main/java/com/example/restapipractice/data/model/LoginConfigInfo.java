package com.example.restapipractice.data.model;

import com.example.restapipractice.data.realm.model.UserInfoRealm;
import com.google.gson.annotations.SerializedName;

public class LoginConfigInfo {
    @SerializedName("userFullName")
    private String mUserFullName;
    @SerializedName("userId")
    private String mUserId;

    public LoginConfigInfo(UserInfoRealm userInfoRealm){
        if(userInfoRealm != null){
            mUserFullName = userInfoRealm.getUserFullName();
            mUserId = userInfoRealm.getUserId();
        }
    }
    public LoginConfigInfo(){};

    public String getUserFullName() {
        return mUserFullName;
    }

    public void setUserFullName(String userFullName) {
        mUserFullName = userFullName;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }
}
