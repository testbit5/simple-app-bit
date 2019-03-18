package com.example.restapipractice.data.source.local;

import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.network.interceptor.response.CategoryResponse;
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
}
