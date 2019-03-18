package com.example.restapipractice.presentation.ListMenu;

import com.example.restapipractice.base.BasePresenter;
import com.example.restapipractice.base.BaseView;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.presentation.viewmodel.CategoryVM;

import java.util.List;

public interface ListMenuContract {
    interface View extends BaseView {
        void showListMenu(List<Account> AccountList);
    }
    interface Presenter extends BasePresenter {
        void retrieveCategory();
    }
}
