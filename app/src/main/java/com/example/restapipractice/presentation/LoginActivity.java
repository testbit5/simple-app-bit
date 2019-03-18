package com.example.restapipractice.presentation;

import android.os.Bundle;

import com.example.restapipractice.R;
import com.example.restapipractice.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public int getContentView() {
        return 0;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }
}
