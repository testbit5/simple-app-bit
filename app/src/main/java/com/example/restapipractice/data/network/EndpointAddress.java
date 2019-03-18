package com.example.restapipractice.data.network;

import com.example.restapipractice.BuildConfig;

public class EndpointAddress {

    private EndpointAddress(){}
    public static String getApiEndpoint(String endpointPath){
        return BuildConfig.SERVER_URL + endpointPath;

    }
    public static final String RETRIEVE_CATEGORY ="categories";
    public static final String LOGIN = "api/login";
    public static final String GET_ALL_DATA = "";
    public static final String GET_DETAIL_DATA = "";

}
