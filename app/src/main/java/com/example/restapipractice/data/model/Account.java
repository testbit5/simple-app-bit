package com.example.restapipractice.data.model;

import com.example.restapipractice.data.realm.model.AccountRealm;
import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("accId")
    private String account_id;
    @SerializedName("accName")
    private String account_name;
    @SerializedName("accBalance")
    private String account_balance;

    public Account(String account_name, String account_balance) {
        this.account_name = account_name;
        this.account_balance = account_balance;
    }

    public Account(String account_name, String account_balance, String account_id) {
        this.account_name = account_name;
        this.account_balance = account_balance;
        this.account_id = account_id;
    }

    public Account(AccountRealm accountRealm){
        this.account_id = accountRealm.getAccId();
        this.account_name = accountRealm.getAccName();
        this.account_balance = accountRealm.getAccBalance();
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(String account_balance) {
        this.account_balance = account_balance;
    }
}
