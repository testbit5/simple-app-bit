package com.example.restapipractice.data;



import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.model.LoginConfigInfo;

import java.util.List;

import io.reactivex.Observable;


//lokal db
public interface LocalApi {

    Observable<Boolean> writeUserInfo(LoginConfigInfo loginConfigInfo);
    Observable<LoginConfigInfo> getUserInfo();
    Observable<Boolean> clearUserInfo();
    Observable<Boolean> addAccount(Account account);
    Observable<List<Account>> getAccountList();
    Observable<Boolean> deleteAccount(Account account);

}
