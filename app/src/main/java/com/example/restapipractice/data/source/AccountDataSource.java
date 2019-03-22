package com.example.restapipractice.data.source;

import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.network.response.CategoryResponse;
import com.example.restapipractice.data.network.response.LoginResponse;
import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.data.network.request.LoginRequest;

import java.util.List;

import io.reactivex.Observable;

public interface AccountDataSource {

    Observable<CategoryResponse> retrieveCategory();

    Observable<List<Account>> retrieveAllAccount();

    Observable<LoginConfigInfo> retrieveUserInfo();

    Observable<LoginResponse> login(LoginRequest loginRequest);

    Observable<Boolean> saveUsername(LoginConfigInfo loginConfigInfo);

    Observable<Boolean> saveAccount(Account saveAccount);

    Observable<Boolean> deleteAccount(String accountId);
}
