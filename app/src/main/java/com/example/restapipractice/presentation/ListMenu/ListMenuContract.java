package com.example.restapipractice.presentation.ListMenu;

import com.example.restapipractice.base.BasePresenter;
import com.example.restapipractice.base.BaseView;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.presentation.viewmodel.ListMenuVM;


import java.util.List;

public interface ListMenuContract {
    interface View extends BaseView {
        void showListMenu(List<ListMenuVM> ListMenuVMList);
        void showSubtitle(String subtitle);
    }
    interface Presenter extends BasePresenter {
        void retrieveMenuList();
        void getUserInfo();
    }
}
