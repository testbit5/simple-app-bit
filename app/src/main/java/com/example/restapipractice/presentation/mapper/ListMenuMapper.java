package com.example.restapipractice.presentation.mapper;

import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.presentation.viewmodel.ListMenuVM;

import java.util.ArrayList;
import java.util.List;

public class ListMenuMapper {

    public static List<ListMenuVM> transform (List<Account> accountList){

        List<ListMenuVM> listMenuVMList = new ArrayList<>();
        List<Account> accountList1 = accountList;
        ListMenuVM listMenuVM;

        for(Account account : accountList1){
            listMenuVM = new ListMenuVM();
            listMenuVM.setAccId(account.getAccount_id());
            listMenuVM.setAccName(account.getAccount_name());
            listMenuVM.setAccBalance(account.getAccount_balance()+"");
            listMenuVMList.add(listMenuVM);
        }

        return listMenuVMList;
    }
}
