package com.example.restapipractice.domain.usecase;

import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.domain.repository.AccountRepository;

import io.reactivex.Observable;

public class DeleteUseCase extends UseCase {

    private AccountRepository mAccountRepository;
    private Account mAccount;
    private String accountId;
    public DeleteUseCase(AccountRepository repository){
        mAccountRepository = repository;
    }

    public void setParam(String accountId){
//        mAccount = account;
        this.accountId = accountId;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mAccountRepository.deleteAccount(accountId);
    }
}
