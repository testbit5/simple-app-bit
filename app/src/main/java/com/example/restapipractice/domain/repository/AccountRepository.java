package com.example.restapipractice.domain.repository;

import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.network.interceptor.response.CategoryResponse;

import java.util.List;

import io.reactivex.Observable;

public interface AccountRepository {

    Observable<CategoryResponse> retrieveCategory();

    //Get List Accounts
    Observable<List<Account>> retrieveAllAccount();
}
