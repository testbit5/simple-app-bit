package com.example.restapipractice.base;

public interface BaseView {

    void showLoadingBar();
    void hideLoadingBar();
    void showFailedErrorMessage(String errorMessage);
    String getErrorMessage();
}
