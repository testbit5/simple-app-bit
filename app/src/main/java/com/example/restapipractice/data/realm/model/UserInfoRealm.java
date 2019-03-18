package com.example.restapipractice.data.realm.model;

import com.example.restapipractice.data.model.LoginConfigInfo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserInfoRealm extends RealmObject {
    @PrimaryKey
    private String mId = "1";
    private String mUserFullName;
    private String mUserId;

    public UserInfoRealm(){}
    public UserInfoRealm(LoginConfigInfo loginConfigInfo){
        mUserFullName = loginConfigInfo.getUserFullName();
        mUserId = loginConfigInfo.getUserId();
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

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
