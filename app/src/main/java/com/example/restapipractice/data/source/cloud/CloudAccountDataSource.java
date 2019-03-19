package com.example.restapipractice.data.source.cloud;

import com.example.restapipractice.data.RestApi;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.data.network.request.LoginRequest;
import com.example.restapipractice.data.network.response.LoginResponse;
import com.example.restapipractice.data.network.EndpointAddress;
import com.example.restapipractice.data.network.response.CategoryResponse;
import com.example.restapipractice.data.source.AccountDataSource;

import java.util.List;

import io.reactivex.Observable;

//klo sourcenya cloud
public class CloudAccountDataSource implements AccountDataSource {

    private final RestApi mRestApi;
    public CloudAccountDataSource(RestApi restApi){mRestApi = restApi;}

    @Override
    public Observable<List<Account>> retrieveAllAccount() {
        return null;
    }

@Override
    public Observable<LoginResponse> login(LoginRequest loginRequest) {
        String fullUrl = EndpointAddress.getApiEndpoint(EndpointAddress.LOGIN);
        return mRestApi.login(fullUrl,loginRequest);
    }

    @Override
    public Observable<Boolean> saveUsername(LoginConfigInfo loginConfigInfo) {
        return null;
    }

    @Override
    public Observable<CategoryResponse> retrieveCategory() {
        String fullUrl = EndpointAddress.getApiEndpoint(EndpointAddress.RETRIEVE_CATEGORY);
        return mRestApi.retrieveCategory(fullUrl);
    }

    @Override
    public Observable<Boolean> saveAccount(Account saveAccount) { return null; }

    @Override
    public Observable<LoginConfigInfo> retrieveUserInfo() {
        return null;
    }
}
