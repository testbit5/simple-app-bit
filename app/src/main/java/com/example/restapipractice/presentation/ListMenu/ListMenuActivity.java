package com.example.restapipractice.presentation.ListMenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListMenuActivity extends BaseActivity implements ListMenuContract.View {
    private List<ListMenuVM> mListMenuVMList;

    private ListMenuAdapter mAdapter;

    private ListMenuContract.Presenter mPresenter;
    Account mAccount;
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

        mAdapter.setOnItemClickListener(new ListMenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListMenuVM listMenuVM) {

                showDeleteAlertDialog(listMenuVM);

            }
        });


        getSubtitle();
//        retrieveMenuList();
//        showListMenu(mListMenuVMList);
    }



    public void showDeleteAlertDialog(ListMenuVM account){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete this Account?");
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });

        builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String accountId = account.getAccId();
//                Log.d("Button Del YES ID", accountId +"");
                mPresenter.deleteAccount(accountId);
            }
        });
        builder.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveMenuList();

    }

    private void initPresenter(){
        mPresenter = new ListMenuPresenter(
                ApplicationComponent.sGetListUseCase(),
                ApplicationComponent.sGetUserInfoUseCase(),
                ApplicationComponent.provideDeleteUseCase(),
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
