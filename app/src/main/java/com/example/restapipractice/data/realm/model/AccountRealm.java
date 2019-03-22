package com.example.restapipractice.data.realm.model;


import com.example.restapipractice.data.model.Account;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AccountRealm extends RealmObject {
    public static final String ACCOUNT_ID = "accId";

    @PrimaryKey
    private String accId;
    private String accName;
    private String accBalance;

    public AccountRealm() {
    }

    public AccountRealm(Account account){
        accId = UUID.randomUUID().toString();
        accName = account.getAccount_name();
        accBalance = account.getAccount_balance();

    }

    public String getAccId() {
        return UUID.randomUUID().toString();
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(String accBalance) {
        this.accBalance = accBalance;
    }
}
