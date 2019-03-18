package com.example.restapipractice.data.source.cloud;

import com.example.restapipractice.data.RestApi;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.network.EndpointAddress;
import com.example.restapipractice.data.network.interceptor.response.CategoryResponse;
import com.example.restapipractice.data.source.AccountDataSource;

import java.util.List;

import io.reactivex.Observable;

//klo sourcenya cloud
public class CloudAccountDataSource implements AccountDataSource {

    private final RestApi mRestApi;
    public CloudAccountDataSource(RestApi restApi){mRestApi = restApi;}

    @Override
    public Observable<List<Account>> retrieveAllAccount() {
        return null;
    }

    @Override
    public Observable<CategoryResponse> retrieveCategory() {
        String fullUrl = EndpointAddress.getApiEndpoint(EndpointAddress.RETRIEVE_CATEGORY);
        return mRestApi.retrieveCategory(fullUrl);
    }
}
