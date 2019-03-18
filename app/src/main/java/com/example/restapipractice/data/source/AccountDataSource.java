package com.example.restapipractice.data.source;

import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.network.interceptor.response.CategoryResponse;

import java.util.List;

import io.reactivex.Observable;

public interface AccountDataSource {

    Observable<CategoryResponse> retrieveCategory();

    Observable<List<Account>> retrieveAllAccount();
}
