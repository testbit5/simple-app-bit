package com.example.restapipractice.presentation.ListMenu;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.restapipractice.ApplicationComponent;
import com.example.restapipractice.R;
import com.example.restapipractice.base.BaseActivity;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.presentation.LoginActivityPresenter;
import com.example.restapipractice.presentation.viewmodel.CategoryVM;
import com.example.restapipractice.presentation.viewmodel.ListMenuVM;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListMenuActivity extends BaseActivity implements ListMenuContract.View {
    private List<ListMenuVM> mListMenuVMList = new ArrayList<>();
    private ListMenuAdapter mAdapter;
    private List<Account> mAccounts;
    private ListMenuContract.Presenter mPresenter;
    Account mAccount;
    TextView txtView_subtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FloatingActionButton btn_add = findViewById(R.id.button_add_note);
        txtView_subtitle = findViewById(R.id.textView_username);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        initPresenter();
        mAccounts = new ArrayList<>();
        mAccounts.add(new Account("1","Tet",35000));
        mAccounts.add(new Account("2","Test",32000));
        mAccounts.add(new Account("3","Tetz",35200));

        mAdapter = new ListMenuAdapter(mAccounts);
        mAdapter.setMenuList(mAccounts);
//        mAdapter.setMenuList(mAccounts);

        recyclerView.setAdapter(mAdapter);

        getSubtitle();

    }

    private void initPresenter(){
        mPresenter = new ListMenuPresenter(
                ApplicationComponent.sGetListUseCase(),
                ApplicationComponent.sGetUserInfoUseCase(),
                this
        );
    }

    private void retrieveMenuList(){
        mPresenter.retrieveMenuList();
    }




    @Override
    public int getContentView() {
        return R.layout.activity_list_menu;
    }

    @Override
    public String getScreenTitle() {
        return getString(R.string.accountList);
    }

    @Override
    public void showListMenu(List<ListMenuVM> ListMenuVMList) {

    }

    private void getSubtitle(){
        mPresenter.getUserInfo();
    }
    @Override
    public void showSubtitle(String subtitle) {
        txtView_subtitle.setText(subtitle);
    }
}
