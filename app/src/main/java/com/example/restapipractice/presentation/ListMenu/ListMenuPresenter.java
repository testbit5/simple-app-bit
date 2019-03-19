package com.example.restapipractice.presentation.ListMenu;

import android.util.Log;

import com.example.restapipractice.base.CommonPresenter;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.domain.usecase.GetListUseCase;
import com.example.restapipractice.domain.usecase.GetUserInfoUseCase;
import com.example.restapipractice.domain.usecase.RetrieveCategoryUseCase;
import com.example.restapipractice.presentation.mapper.ListMenuMapper;
import com.example.restapipractice.presentation.viewmodel.ListMenuVM;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class ListMenuPresenter extends CommonPresenter implements ListMenuContract.Presenter {

    private GetListUseCase mGetListUseCase;
    private GetUserInfoUseCase mGetUserInfoUseCase;
    private ListMenuContract.View mView;


    public ListMenuPresenter(
            GetListUseCase getListUseCase,
            GetUserInfoUseCase getUserInfoUseCase,
            ListMenuContract.View view
    ){
        mGetListUseCase = getListUseCase;
        mGetUserInfoUseCase = getUserInfoUseCase;
        mView = view;
    }

    @Override
    public void retrieveMenuList() {
        //Disposable = buat retrieve dari realm
        mGetListUseCase.execute(new DisposableObserver<List<Account>>() {
            @Override
            public void onNext(List<Account> accountList) {
                mView.showListMenu(ListMenuMapper.transform(accountList));

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    public void getUserInfo(){

        mGetUserInfoUseCase.execute(new DisposableObserver<LoginConfigInfo>() {
            @Override
            public void onNext(LoginConfigInfo loginConfigInfo) {

                mView.showSubtitle(loginConfigInfo.getUserFullName());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void emptyAdapter() {

    }

    @Override
    public void destroy() {
        mGetListUseCase.unsubscribe();
        mGetUserInfoUseCase.unsubscribe();
    }
}
