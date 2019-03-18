package com.example.restapipractice.data.network.response;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("errorCode")
    private String mErrorCode;

    @SerializedName("errorMessage")
    private String mErrorMessage;

    public String getErrorCode() {
        return mErrorCode;
    }

    public void setErrorCode(String errorCode) {
        mErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage = errorMessage;
    }
}
