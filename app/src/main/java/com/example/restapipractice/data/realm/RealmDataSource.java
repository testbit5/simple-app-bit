package com.example.restapipractice.data.realm;


import com.example.restapipractice.data.LocalApi;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.data.realm.model.UserInfoRealm;

import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmDataSource implements LocalApi {
    @Override
    public Observable<Boolean> writeUserInfo(LoginConfigInfo loginConfigInfo) {
        if(loginConfigInfo != null){
            UserInfoRealm userInfoRealm = new UserInfoRealm(loginConfigInfo);
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(transactionRealm ->
                    transactionRealm.copyToRealmOrUpdate(userInfoRealm));
            realm.close();
            return Observable.just(realm.isClosed());
        } else {
            return Observable.just(true);
        }
    }

    @Override
    public Observable<LoginConfigInfo> getUserInfo() {
        Realm realm = Realm.getDefaultInstance();
        UserInfoRealm userInfoRealm = realm.where(UserInfoRealm.class).findFirst();
        if(userInfoRealm != null){
            LoginConfigInfo loginConfigInfo = new LoginConfigInfo(userInfoRealm);
            realm.close();
            return Observable.just(loginConfigInfo);
        }else{
            return Observable.just(new LoginConfigInfo());
        }

    }

    @Override
    public Observable<Boolean> clearUserInfo() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<UserInfoRealm> results = realm.where(UserInfoRealm.class).findAll();
        realm.executeTransaction(transactionRealm -> results.deleteAllFromRealm());
        realm.close();
        return Observable.just(realm.isClosed());
    }

    @Override
    public Observable<Boolean> addAccount(Account account) {
        return null;
    }

    @Override
    public Observable<List<Account>> getAccountList() {
        return null;
    }

    @Override
    public Observable<Boolean> deleteAccount(int id) {
        return null;
    }

//    @Override
//    public Observable<Boolean> writeUserInfo(LoginConfigInfo loginConfigInfo){}


}
