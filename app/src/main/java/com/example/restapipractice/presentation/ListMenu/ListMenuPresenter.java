package com.example.restapipractice.presentation.ListMenu;

import android.util.Log;

import com.example.restapipractice.base.CommonPresenter;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.domain.usecase.GetListUseCase;
import com.example.restapipractice.domain.usecase.RetrieveCategoryUseCase;
import com.example.restapipractice.presentation.mapper.ListMenuMapper;
import com.example.restapipractice.presentation.viewmodel.ListMenuVM;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class ListMenuPresenter extends CommonPresenter implements ListMenuContract.Presenter {

    private GetListUseCase mGetListUseCase;
    private ListMenuContract.View mView;

    public ListMenuPresenter(
            GetListUseCase getListUseCase,
            ListMenuContract.View view
    ){
        mGetListUseCase = getListUseCase;
        mView = view;
    }

    @Override
    public void retrieveMenuList() {
        //Disposable = buat retrieve dari realm
        mGetListUseCase.execute(new DisposableObserver<List<Account>>() {
            @Override
            public void onNext(List<Account> accountList) {
                Log.d("OnNext presenter","TEST");
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

    @Override
    public void destroy() {
        mGetListUseCase.unsubscribe();
    }
}
