package com.example.restapipractice.domain.repository;

import com.example.restapipractice.data.network.interceptor.response.CategoryResponse;

import io.reactivex.Observable;

public interface AccountRepository {

    Observable<CategoryResponse> retrieveCategory();
}
