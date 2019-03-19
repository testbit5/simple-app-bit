package com.example.restapipractice.presentation;

import com.example.restapipractice.base.CommonPresenter;
import com.example.restapipractice.component.CallBackWrapper;
import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.data.network.request.LoginRequest;
import com.example.restapipractice.data.network.response.BaseResponse;
import com.example.restapipractice.data.network.response.CategoryResponse;
import com.example.restapipractice.data.network.response.LoginResponse;
import com.example.restapipractice.domain.usecase.LoginUseCase;
import com.example.restapipractice.domain.usecase.RetrieveCategoryUseCase;
import com.example.restapipractice.domain.usecase.SaveLoginUsernameUseCase;
import com.example.restapipractice.presentation.mapper.CategoryMapper;

import io.reactivex.observers.DisposableObserver;

public class LoginActivityPresenter extends CommonPresenter implements LoginActivityContract.Presenter {

    private LoginUseCase mLoginUseCase;
    private SaveLoginUsernameUseCase mSaveLoginUsernameUseCase;
    private LoginActivityContract.View mView;

    public LoginActivityPresenter(LoginUseCase loginUseCase,
                                  SaveLoginUsernameUseCase saveLoginUsernameUseCase,
                                  LoginActivityContract.View view){
        mLoginUseCase = loginUseCase;
        mSaveLoginUsernameUseCase = saveLoginUsernameUseCase;
        mView = view;
    }

    @Override
    public void OnClickLogin(LoginRequest request) {
        mView.showLoadingBar();
        mLoginUseCase.setRequest(request);
        mLoginUseCase.execute(new CallBackWrapper<LoginResponse>(mView) {
            @Override
            protected void onSuccess(LoginResponse response) {
                mView.hideLoadingBar();
                if(response.getLoginConfigInfo() != null) {
                    saveUsername(response.getLoginConfigInfo());
                }
            }

            @Override
            protected void onFailed(Throwable throwable) {
                mView.hideLoadingBar();
                showErrorMessage(throwable, mView);
            }
        });
    }

    private void saveUsername(LoginConfigInfo loginConfigInfo){
        mSaveLoginUsernameUseCase.saveUsername(loginConfigInfo);
        mSaveLoginUsernameUseCase.execute(new DisposableObserver() {
            @Override
            public void onNext(Object o) {
                mView.startNextScreen();
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
        mLoginUseCase.unsubscribe();
        mSaveLoginUsernameUseCase.unsubscribe();
    }

}