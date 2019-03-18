package com.example.restapipractice.data.network.retrofit;

import com.example.restapipractice.data.network.request.LoginRequest;
import com.example.restapipractice.data.network.response.CategoryResponse;
import com.example.restapipractice.data.network.response.LoginResponse;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

import static com.example.restapipractice.Constants.REQUEST_HEADER_CONTENT_TYPE;

public interface RetrofitRestApi {

    @Headers({REQUEST_HEADER_CONTENT_TYPE})
    @GET
    Observable<CategoryResponse> retrieveCategory(@Url String fullUrl);

    @Headers({REQUEST_HEADER_CONTENT_TYPE})
    @POST
    Observable<LoginResponse> login(@Url String fullUrl, @Body LoginRequest loginRequest);
}
