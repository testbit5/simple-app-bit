package com.example.restapipractice.domain.usecase;

import com.example.restapipractice.data.network.request.LoginRequest;
import com.example.restapipractice.domain.repository.AccountRepository;

import io.reactivex.Observable;

public class LoginUseCase extends UseCase {

    private AccountRepository mAccountRepository;

    private LoginRequest mLoginRequest;

    public LoginUseCase(AccountRepository accountRepository){
        mAccountRepository = accountRepository;
    }

    public void setRequest(LoginRequest loginRequest){
        mLoginRequest = loginRequest;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mAccountRepository.login(mLoginRequest);
    }

}
