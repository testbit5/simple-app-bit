package com.example.restapipractice.base;

import com.example.restapipractice.data.network.ServiceApiFail;

import java.net.SocketTimeoutException;

public class CommonPresenter {

    public void showErrorMessage(Throwable throwable, BaseView baseView){
        if(throwable instanceof ServiceApiFail){
            ServiceApiFail serviceApiFail = (ServiceApiFail) throwable;
            baseView.showFailedErrorMessage(serviceApiFail.getErrorMessage());
        }
        else{
            if(throwable instanceof SocketTimeoutException){
                baseView.showFailedErrorMessage(baseView.getErrorMessage());
            } else {
                baseView.showFailedErrorMessage(baseView.getErrorMessage());
            }
        }
    }
}
