package com.example.restapipractice.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.restapipractice.ApplicationComponent;
import com.example.restapipractice.R;
import com.example.restapipractice.base.BaseActivity;
import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.data.network.request.LoginRequest;
import com.example.restapipractice.presentation.ListMenu.ListMenuActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.nio.charset.Charset;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends BaseActivity implements LoginActivityContract.View {

    @BindView(R.id.textInputUname)
    TextInputLayout mTextInputLayoutUname;

    @BindView(R.id.textInputPass)
    TextInputLayout mTextInputLayoutPass;

    @BindView(R.id.editTextUname)
    EditText mEditTextUname;

    @BindView(R.id.editTextPass)
    EditText mEditTextPass;

    @BindView(R.id.btnLogin)
    Button mBtnLogin;

    @BindView(R.id.toolbarLogin)
    Toolbar mToolbarLogin;

    private LoginActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        setSupportActionBar(mToolbarLogin);
    }

    private void initPresenter(){
        mBtnLogin.setEnabled(false);
        mPresenter = new LoginActivityPresenter(
                ApplicationComponent.executeLogin(),
                ApplicationComponent.provideSaveUsername(),
                this
        );
    }

    @OnTextChanged({R.id.editTextUname, R.id.editTextPass})
    protected void onUnameTxtChanged(CharSequence text) {
        String uname = mEditTextUname.getText().toString();
        String pass = mEditTextPass.getText().toString();
        int counter = 0;
            if(uname.length() > 5){
                ++counter;
                mTextInputLayoutUname.setError(null);
            }else{
                mTextInputLayoutUname.setError("Username at least 6 characters");
                --counter;
            }

             if (pass.length() > 5){
                 ++counter;
                 mTextInputLayoutPass.setError(null);
             }else {
                 mTextInputLayoutPass.setError("Password at least 6 characters");
                 --counter;
             }

            if(counter == 2) {
                mBtnLogin.setEnabled(true);
            }else{
                mBtnLogin.setEnabled(false);
            }
    }

    @OnClick(R.id.btnLogin)
    public void loginClicked(){
        String uname = mEditTextUname.getText().toString();
        String pass = mEditTextPass.getText().toString();
        LoginRequest request = new LoginRequest(uname, pass);
        mPresenter.OnClickLogin(request);
    }

    @Override
    public void startNextScreen() {
        Intent intent = new Intent(LoginActivity.this, ListMenuActivity.class);
        startActivity(intent);

    }

    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public String getScreenTitle() {
        return getString(R.string.login_title);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
