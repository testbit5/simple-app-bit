package com.example.restapipractice.presentation.AddAccount;

import com.example.restapipractice.base.BasePresenter;
import com.example.restapipractice.base.BaseView;
import com.example.restapipractice.data.model.Account;

public interface AddAccountContract {

    interface View extends BaseView{
        void showListAccount();
    }

    interface Presenter extends BasePresenter{
        void onClickSaveAccount(Account saveAccountRequest);
    }

}
