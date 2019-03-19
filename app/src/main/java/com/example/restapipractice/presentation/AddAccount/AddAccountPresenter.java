package com.example.restapipractice.presentation.AddAccount;

import com.example.restapipractice.base.CommonPresenter;
import com.example.restapipractice.component.CallBackWrapper;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.domain.usecase.SaveAccountDataUseCase;

import io.reactivex.observers.DisposableObserver;

public class AddAccountPresenter extends CommonPresenter implements AddAccountContract.Presenter{

    private SaveAccountDataUseCase mSaveAccountDataUseCase;
    private AddAccountContract.View mView;

    public AddAccountPresenter(SaveAccountDataUseCase saveAccountDataUseCase, AddAccountContract.View view){
        mSaveAccountDataUseCase = saveAccountDataUseCase;
        mView = view;
    }

    @Override
    public void onClickSaveAccount(Account saveAccount) {
        mView.showLoadingBar();
        mSaveAccountDataUseCase.setSaveAccount(saveAccount);
        mSaveAccountDataUseCase.execute(new DisposableObserver() {
            @Override
            public void onNext(Object o) {
                mView.hideLoadingBar();
                mView.showListAccount();
            }

            @Override
            public void onError(Throwable throwable) {
                mView.hideLoadingBar();
                showErrorMessage(throwable, mView);
            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void destroy() {
        mSaveAccountDataUseCase.unsubscribe();
    }
}
