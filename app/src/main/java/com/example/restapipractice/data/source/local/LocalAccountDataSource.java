package com.example.restapipractice.data.source.local;

import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.network.response.CategoryResponse;
import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.data.network.EndpointAddress;
import com.example.restapipractice.data.network.request.LoginRequest;
import com.example.restapipractice.data.network.response.LoginResponse;
import com.example.restapipractice.data.source.AccountDataSource;
import com.example.restapipractice.data.LocalApi;

import java.util.List;

import io.reactivex.Observable;

//buat akses lokal database macam Realm(sqlite)
public class LocalAccountDataSource implements AccountDataSource {
    private LocalApi mContentResolverDataSource;
    private LocalApi mLocalApi;

    public LocalAccountDataSource(LocalApi contentResolverDataSource, LocalApi localApi){
        mContentResolverDataSource = contentResolverDataSource;
        mLocalApi = localApi;
    }

    @Override
    public Observable<CategoryResponse> retrieveCategory() {
        return null;
    }

    @Override
    public Observable<List<Account>> retrieveAllAccount() {
        return mLocalApi.getAccountList();

    }

@Override
    public Observable<LoginResponse> login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public Observable<Boolean> saveUsername(LoginConfigInfo loginConfigInfo) {
        return mLocalApi.writeUserInfo(loginConfigInfo);
    }
}
