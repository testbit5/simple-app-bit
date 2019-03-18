package com.example.restapipractice.data.source;

import com.example.restapipractice.data.network.interceptor.response.CategoryResponse;

import io.reactivex.Observable;

public interface AccountDataSource {

    Observable<CategoryResponse> retrieveCategory();
}
