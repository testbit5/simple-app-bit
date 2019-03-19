package com.example.restapipractice.presentation.ListMenu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.restapipractice.ApplicationComponent;
import com.example.restapipractice.R;
import com.example.restapipractice.base.BaseActivity;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.presentation.AddAccount.AddAccountActivity;
import com.example.restapipractice.presentation.LoginActivityPresenter;
import com.example.restapipractice.presentation.viewmodel.CategoryVM;
import com.example.restapipractice.presentation.viewmodel.ListMenuVM;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListMenuActivity extends BaseActivity implements ListMenuContract.View {
    private List<ListMenuVM> mListMenuVMList;

    private ListMenuAdapter mAdapter;

    private ListMenuContract.Presenter mPresenter;

    TextView txtView_subtitle;
    FloatingActionButton btn_add;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn_add = findViewById(R.id.button_add_note);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListMenuActivity.this, AddAccountActivity.class);
                startActivity(intent);
            }
        });

        txtView_subtitle = findViewById(R.id.textView_username);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        initPresenter();

        mListMenuVMList = new ArrayList<>();

        mAdapter = new ListMenuAdapter(mListMenuVMList);

        recyclerView.setAdapter(mAdapter);

        getSubtitle();
//        retrieveMenuList();
//        showListMenu(mListMenuVMList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ON RESUME","RESUME");
        retrieveMenuList();

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
        Log.d("ListMenuVMList SIZE = " , ListMenuVMList.size()+"");

        mAdapter.setMenuList(ListMenuVMList);

    }
    //getSubtitle -> panggil method getUserInfo di presenter-> panggil showSubtitle
    private void getSubtitle(){
        mPresenter.getUserInfo();
    }
    @Override
    public void showSubtitle(String subtitle) {
        txtView_subtitle.setText(subtitle);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }
}
