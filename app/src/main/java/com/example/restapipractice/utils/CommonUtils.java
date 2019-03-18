package com.example.restapipractice.utils;

import com.example.restapipractice.Constants;

public class CommonUtils {

    public static boolean isSuccess(String errorCode){
        return Constants.SUCCESS_CODE.equals(errorCode);
    }


}
