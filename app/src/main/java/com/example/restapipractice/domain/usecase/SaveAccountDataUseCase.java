package com.example.restapipractice.domain.usecase;

import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.domain.repository.AccountRepository;

import io.reactivex.Observable;

public class SaveAccountDataUseCase extends UseCase {

    private AccountRepository mAccountRepository;

    private Account mAccount;

    public SaveAccountDataUseCase(AccountRepository repository){
        mAccountRepository = repository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mAccountRepository.saveAccount(mAccount);
    }

    public void setSaveAccount(Account request){
        mAccount = request;
    }
}
