package com.example.restapipractice.data.network.retrofit;


import com.example.android.cleanarchitecture.AndroidApplication;
import com.example.restapipractice.BuildConfig;
import com.example.restapipractice.data.RestApi;
import com.example.restapipractice.data.network.request.LoginRequest;
import com.example.restapipractice.data.network.response.CategoryResponse;
import com.example.restapipractice.data.network.response.LoginResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRestApiImpl implements RestApi {
    private static final int CACHE_SIZE_BYTES = 1024 * 1024 * 2;
    private static final String SERVER_URL = BuildConfig.SERVER_URL;
    private static final int CONNECTION_TIMEOUT = 60;
    private static final int READ_TIMEOUT = 60;

    private RetrofitRestApi mApiService;

    public RetrofitRestApiImpl(){ buildRetrofit();}

    private void buildRetrofit(){
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(SERVER_URL)
                .client(createHttpClient(true))
                .build();
        mApiService = retrofit.create(RetrofitRestApi.class);
    }

    private OkHttpClient createHttpClient(boolean cacheable){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        if(cacheable){
            setCache(httpClient);
        }
        setTimeout(httpClient);
        setLogger(httpClient);
        return httpClient.build();
    }

    private void setCache(OkHttpClient.Builder okHttpClientBuilder){
        okHttpClientBuilder.cache(
            new Cache(AndroidApplication.getAppContext().getCacheDir(), CACHE_SIZE_BYTES));

    }

    private void setTimeout(OkHttpClient.Builder okHttpClientBuilder){
        okHttpClientBuilder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        okHttpClientBuilder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);

    }

    private void setLogger(OkHttpClient.Builder okHttpClientBuilder){
        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(logging);
        }
    }

    @Override
    public Observable<LoginResponse> login(String fullUrl, LoginRequest loginRequest) {
        return mApiService.login(fullUrl, loginRequest);
    }

    //tinggal ctrl+i untuk manggil dari implement RestApi
    @Override
    public Observable<CategoryResponse> retrieveCategory(String fullUrl) {

        return mApiService.retrieveCategory(fullUrl);
    }
}
