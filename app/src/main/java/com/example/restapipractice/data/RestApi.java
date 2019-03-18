package com.example.restapipractice.data;

import com.example.restapipractice.data.network.request.LoginRequest;
import com.example.restapipractice.data.network.response.CategoryResponse;
import com.example.restapipractice.data.network.response.LoginResponse;


import io.reactivex.Observable;
import retrofit2.http.Url;

public interface RestApi {

    Observable<CategoryResponse> retrieveCategory(@Url String fullUrl);

    Observable<LoginResponse> login(@Url String fullUrl, LoginRequest loginRequest);


}
