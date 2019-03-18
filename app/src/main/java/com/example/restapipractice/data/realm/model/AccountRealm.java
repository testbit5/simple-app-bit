package com.example.restapipractice.data.realm.model;


import com.example.restapipractice.data.model.Account;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AccountRealm extends RealmObject {
    @PrimaryKey
    private String accId;
    private String accName;
    private Integer accBalance;

    public AccountRealm() {
    }

    public AccountRealm(Account account){
        accId = account.getAccount_id();
        accName = account.getAccount_name();
        accBalance = account.getAccount_balance();

    }

    public String getAccId() {
        return accId;
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

    public Integer getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(Integer accBalance) {
        this.accBalance = accBalance;
    }
}
