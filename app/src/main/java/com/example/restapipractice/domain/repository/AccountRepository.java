package com.example.restapipractice.domain.repository;

import com.example.restapipractice.data.model.Account;

import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.data.network.request.LoginRequest;
import com.example.restapipractice.data.network.response.CategoryResponse;
import com.example.restapipractice.data.network.response.LoginResponse;

import java.util.List;

import io.reactivex.Observable;

public interface AccountRepository {

    Observable<CategoryResponse> retrieveCategory();
    //Get List Accounts
    Observable<List<Account>> retrieveAllAccount();
    //Get an Account
    Observable<LoginConfigInfo> retrieveUserInfo();

    Observable<LoginResponse> login(LoginRequest loginRequest);

    Observable<Boolean> saveUsername(LoginConfigInfo loginConfigInfo);

    Observable<Boolean> saveAccount(Account saveAccount);

    Observable<Boolean> deleteAccount(String accountId);
}
