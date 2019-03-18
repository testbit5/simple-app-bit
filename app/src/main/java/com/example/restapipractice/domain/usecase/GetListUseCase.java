package com.example.restapipractice.domain.usecase;

import com.example.restapipractice.domain.repository.AccountRepository;

import io.reactivex.Observable;

public class GetListUseCase extends UseCase{


    private AccountRepository mAccountRepository;
    public GetListUseCase(AccountRepository accountRepository){
        mAccountRepository = accountRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mAccountRepository.retrieveAllAccount();
    }

}
