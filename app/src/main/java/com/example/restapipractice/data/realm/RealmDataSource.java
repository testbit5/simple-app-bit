package com.example.restapipractice.data.realm;


import com.example.restapipractice.data.LocalApi;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.data.realm.model.AccountRealm;
import com.example.restapipractice.data.realm.model.UserInfoRealm;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

//Tempat kodingan Database
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
        if(account != null){
            AccountRealm accountRealm = new AccountRealm(account);
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(transactionRealm ->
                    transactionRealm.copyToRealm(accountRealm));
            realm.close();
            return Observable.just(realm.isClosed());
        } else {
            return Observable.just(true);
        }
    }

    /*
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
     */
    @Override
    public Observable<List<Account>> getAccountList() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<AccountRealm> accountRealms = realm.where(AccountRealm.class).findAll();
        List<AccountRealm> ListAccountRealm = realm.copyFromRealm(accountRealms);
        List<Account> accountList = new ArrayList<>();
        if(accountRealms != null){

            for (AccountRealm accountRealm : ListAccountRealm) {
                Account account = new Account(accountRealm);
                accountList.add(account);
            }

            realm.close();
            return Observable.just(accountList);
        }else{
            return null;
        }
    }

    @Override
    public Observable<Boolean> deleteAccount(int id) {
//        Realm realm = Realm.getDefaultInstance();
//        RealmResults<UserInfoRealm> userInfoRealm = realm
//                .where(UserInfoRealm.class)
//                .findAll()
//                .deleteFromRealm();
//        if(userInfoRealm != null){
//            realm.close();
//            return Observable.just(userInfoRealm);
//        }else{
//            return Observable.just(userInfoRealm);
//        }

        return null;
    }

//    @Override
//    public Observable<Boolean> writeUserInfo(LoginConfigInfo loginConfigInfo){}


}
