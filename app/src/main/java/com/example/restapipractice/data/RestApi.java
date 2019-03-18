package com.example.restapipractice.data;

import com.example.restapipractice.data.network.interceptor.response.CategoryResponse;


import io.reactivex.Observable;
import retrofit2.http.Url;

public interface RestApi {

    Observable<CategoryResponse> retrieveCategory(@Url String fullUrl);



}
