package com.example.restapipractice.domain.usecase;

import com.example.restapipractice.data.model.LoginConfigInfo;
import com.example.restapipractice.domain.repository.AccountRepository;

import io.reactivex.Observable;

public class SaveLoginUsernameUseCase extends UseCase {

    private AccountRepository mAccountRepository;
    private LoginConfigInfo mLoginConfigInfo;

    @Override
    protected Observable buildUseCaseObservable() {
        return mAccountRepository.saveUsername(mLoginConfigInfo);
    }

    public SaveLoginUsernameUseCase(AccountRepository accountRepository){
        mAccountRepository = accountRepository;
    }

    public void saveUsername(LoginConfigInfo loginConfigInfo){
        mLoginConfigInfo = loginConfigInfo;
    }

}
