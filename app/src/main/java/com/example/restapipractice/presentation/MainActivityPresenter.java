package com.example.restapipractice.presentation;

import com.example.restapipractice.base.CommonPresenter;
import com.example.restapipractice.component.CallBackWrapper;
import com.example.restapipractice.data.model.Category;
import com.example.restapipractice.data.network.interceptor.response.CategoryResponse;
import com.example.restapipractice.domain.usecase.RetrieveCategoryUseCase;
import com.example.restapipractice.domain.usecase.UseCase;
import com.example.restapipractice.presentation.mapper.CategoryMapper;

import io.reactivex.observers.DisposableObserver;

public class MainActivityPresenter extends CommonPresenter implements MainActivityContract.Presenter {

    private RetrieveCategoryUseCase mRetrieveCategoryUseCase;

    private MainActivityContract.View mView;

    public MainActivityPresenter(
            RetrieveCategoryUseCase retrieveCategoryUseCase,
            MainActivityContract.View view
    ){
        mRetrieveCategoryUseCase = retrieveCategoryUseCase;
        mView = view;
    }

    @Override
    public void retrieveCategory() {
        mView.showLoadingBar();
        mRetrieveCategoryUseCase.execute(new CallBackWrapper<CategoryResponse>(mView) {
            @Override
            public void onSuccess(CategoryResponse response) {
                mView.hideLoadingBar();
                if(!response.getCategoryList().isEmpty()){
                    mView.showChipCategory(CategoryMapper.transform(response));
                }
            }
            @Override
            public void onFailed(Throwable throwable) {
                mView.hideLoadingBar();
                showErrorMessage(throwable,mView);
            }

        });
    }

    @Override
    public void destroy() {
        mRetrieveCategoryUseCase.unsubscribe();
    }
}
