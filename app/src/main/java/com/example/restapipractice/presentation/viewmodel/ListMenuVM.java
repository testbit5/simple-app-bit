package com.example.restapipractice.presentation.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class ListMenuVM implements Parcelable {

    public static final Creator<ListMenuVM> CREATOR = new Creator<ListMenuVM>() {
        @Override
        public ListMenuVM createFromParcel(Parcel source) {
            return new ListMenuVM(source);
        }

        @Override
        public ListMenuVM[] newArray(int size) {
            return new ListMenuVM[size];
        }
    };

    private String accId;
    private String accName;
    private String accBalance;

    public ListMenuVM(){}

    protected ListMenuVM(Parcel source){
        accId = source.readString();
        accName = source.readString();
        accBalance = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(accId);
        dest.writeString(accName);
        dest.writeString(accBalance);
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

    public String getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(String accBalance) {
        this.accBalance = accBalance;
    }
}
