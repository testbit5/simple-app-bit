package com.example.restapipractice.component;

import com.example.restapipractice.base.BaseView;
import com.example.restapipractice.data.network.ServiceApiFail;
import com.example.restapipractice.data.network.response.BaseResponse;
import com.example.restapipractice.utils.CommonUtils;

import io.reactivex.observers.DisposableObserver;

public abstract class CallBackWrapper<T extends BaseResponse> extends DisposableObserver<T> {

    private BaseView mBaseView;

    public CallBackWrapper(BaseView baseView) {mBaseView = baseView;}

    protected abstract void onSuccess(T t);

    @Override
    public void onNext(T t) {
        if(CommonUtils.isSuccess(t.getErrorCode())){
            onSuccess(t);
        }
        else{
            onError(new ServiceApiFail(t.getErrorCode(),t.getErrorMessage()));
        }
    }

    @Override
    public void onComplete() {
        //default ignored
    }

    @Override
    public void onError(Throwable throwable) {
        onFailed(throwable);
    }

    protected abstract void onFailed(Throwable throwable);
}
