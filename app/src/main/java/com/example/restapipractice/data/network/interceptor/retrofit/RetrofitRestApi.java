package com.example.restapipractice.data.network.interceptor.retrofit;

import com.example.restapipractice.data.network.interceptor.response.CategoryResponse;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

import static com.example.restapipractice.Constants.REQUEST_HEADER_CONTENT_TYPE;

public interface RetrofitRestApi {

    @Headers({REQUEST_HEADER_CONTENT_TYPE})
    @GET
    Observable<CategoryResponse> retrieveCategory(@Url String fullUrl);

}
