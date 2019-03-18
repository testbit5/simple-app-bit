package com.example.restapipractice.domain.usecase;

import com.example.restapipractice.domain.repository.AccountRepository;

import io.reactivex.Observable;

public class RetrieveCategoryUseCase extends UseCase{

    private AccountRepository mAccountRepository;
    public RetrieveCategoryUseCase(AccountRepository accountRepository){
        mAccountRepository = accountRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mAccountRepository.retrieveCategory();
    }
}
