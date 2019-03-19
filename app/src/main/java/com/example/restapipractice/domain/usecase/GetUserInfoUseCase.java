package com.example.restapipractice.domain.usecase;

import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.domain.repository.AccountRepository;

import io.reactivex.Observable;

public class GetUserInfoUseCase extends UseCase {

    private AccountRepository mAccountRepository;



    public GetUserInfoUseCase(AccountRepository accountRepository) {
        mAccountRepository = accountRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mAccountRepository.retrieveUserInfo();
    }
}
