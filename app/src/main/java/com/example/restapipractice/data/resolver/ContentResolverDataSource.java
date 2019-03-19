package com.example.restapipractice.data.resolver;



import com.example.restapipractice.data.LocalApi;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.model.LoginConfigInfo;

import java.util.List;

import io.reactivex.Observable;

//buat simpen cache memory melalui observable
public class ContentResolverDataSource implements LocalApi {
    @Override
    public Observable<Boolean> writeUserInfo(LoginConfigInfo loginConfigInfo) {
        return null;
    }

    @Override
    public Observable<LoginConfigInfo> getUserInfo() {
        return null;
    }

    @Override
    public Observable<Boolean> clearUserInfo() {
        return null;
    }

    @Override
    public Observable<Boolean> addAccount(Account account) {
        return null;
    }

    @Override
    public Observable<List<Account>> getAccountList() {
        return null;
    }

    @Override
    public Observable<Boolean> deleteAccount(int id) {
        return null;
    }

}
