package com.example.restapipractice.base;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restapipractice.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    public static final String TAG = BaseActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    @Nullable
    Toolbar mToolbar;

    @BindView(R.id.tv_toolbar_title)
    @Nullable
    TextView mTvToolbarTitle;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getContentView());
        ButterKnife.bind(this);
        setToolbar();

    }

    public abstract int getContentView();

    public abstract String getScreenTitle();

    public void hideLeftMenu(){}

    public void hideRightMenu(){}

    public void showFailedErrorMessage(String errorMessage){
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    public String getErrorMessage(){
        return getString(R.string.global_error_message);
    }

    private void setToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setTitle("");
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setBackgroundDrawable(
                    new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        }

        if (mTvToolbarTitle != null) {
            mTvToolbarTitle.setText(getScreenTitle());
        }
    }

    public void showLoadingBar(){
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this, R.style.ProgressDialogTheme);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        mProgressDialog.show();
    }



    public void hideLoadingBar(){
        if(mProgressDialog != null) mProgressDialog.dismiss();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
