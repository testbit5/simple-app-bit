package com.example.restapipractice.presentation;

import com.example.restapipractice.base.BasePresenter;
import com.example.restapipractice.base.BaseView;
import com.example.restapipractice.data.model.Category;
import com.example.restapipractice.presentation.viewmodel.CategoryVM;

import java.util.List;

public interface MainActivityContract {
    interface View extends BaseView {
        void showChipCategory(List<CategoryVM> categoryVMList);
    }
    interface Presenter extends BasePresenter{
        void retrieveCategory();
    }
}
