package com.example.restapipractice.presentation;

import com.example.restapipractice.base.BasePresenter;
import com.example.restapipractice.base.BaseView;
import com.example.restapipractice.data.network.request.LoginRequest;

public interface LoginActivityContract {

    interface View extends BaseView {
        void startNextScreen();
    }
    interface Presenter extends BasePresenter {
        void OnClickLogin(LoginRequest request);

    }
}
