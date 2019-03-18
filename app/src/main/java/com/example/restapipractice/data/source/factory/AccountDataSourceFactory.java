package com.example.restapipractice.data.source.factory;

import com.example.restapipractice.data.LocalApi;
import com.example.restapipractice.data.RestApi;
import com.example.restapipractice.data.network.interceptor.retrofit.RetrofitRestApiImpl;
import com.example.restapipractice.data.realm.RealmDataSource;
import com.example.restapipractice.data.resolver.ContentResolverDataSource;
import com.example.restapipractice.data.source.AccountDataSource;
import com.example.restapipractice.data.source.cloud.CloudAccountDataSource;
import com.example.restapipractice.data.source.local.LocalAccountDataSource;

public class AccountDataSourceFactory {
    public AccountDataSource createCloudDataSource(){
        RestApi restApi = new RetrofitRestApiImpl();
        return new CloudAccountDataSource(restApi);
    }
    public AccountDataSource createLocalDataSource(){
        LocalApi localApi = new RealmDataSource();
        ContentResolverDataSource contentResolverDataSource = new ContentResolverDataSource();
        return new LocalAccountDataSource(contentResolverDataSource, localApi);
    }
}
