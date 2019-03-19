package com.example.restapipractice.presentation.AddAccount;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restapipractice.ApplicationComponent;
import com.example.restapipractice.R;
import com.example.restapipractice.base.BaseActivity;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.realm.model.AccountRealm;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;

public class AddAccountActivity extends BaseActivity implements AddAccountContract.View {

    @BindView(R.id.editTextAccName)
    EditText mAccName;

    @BindView(R.id.editTextAccBalance)
    EditText mAccBalance;

    @BindView(R.id.btnSaveAccount)
    Button mBtnSaveAccount;

    private AddAccountPresenter mAddAccountPresenter;

    String accName = "";
    String accBalance = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
//        setSupportActionBar(mToolbar);
    }

    public void initPresenter(){
        mBtnSaveAccount.setEnabled(true);
        mAddAccountPresenter = new AddAccountPresenter(ApplicationComponent.provideSaveAccountData(),
                this);
    }

    @OnClick(R.id.btnSaveAccount)
    void OnClickSaveBtn(){
        accName = mAccName.getText().toString();
        accBalance = mAccBalance.getText().toString();
        Account saveRequest = new Account(accName, accBalance);
        mAddAccountPresenter.onClickSaveAccount(saveRequest);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_add_account;
    }

    @Override
    public String getScreenTitle() {
        return getString(R.string.add_account_title);
    }

    @Override
    public void showListAccount() {
        setResult(RESULT_OK);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAddAccountPresenter.destroy();
    }
}
