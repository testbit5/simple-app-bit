package com.example.restapipractice;

import com.example.restapipractice.data.source.AccountDataSource;
import com.example.restapipractice.data.source.cloud.CloudAccountDataSource;
import com.example.restapipractice.data.source.factory.AccountDataSourceFactory;
import com.example.restapipractice.domain.repository.AccountRepository;
import com.example.restapipractice.domain.repository.AccountRepositoryImpl;
import com.example.restapipractice.domain.usecase.LoginUseCase;
import com.example.restapipractice.domain.usecase.RetrieveCategoryUseCase;
import com.example.restapipractice.domain.usecase.SaveAccountDataUseCase;
import com.example.restapipractice.domain.usecase.SaveLoginUsernameUseCase;

@SuppressWarnings("ALL")
public class ApplicationComponent {
    private ApplicationComponent(){}

    private static AccountRepository provideAccountRepository(){
        AccountDataSourceFactory accountDataSourceFactory = new AccountDataSourceFactory();

        return new AccountRepositoryImpl(accountDataSourceFactory.createCloudDataSource(),
               accountDataSourceFactory.createLocalDataSource()
        );
    }

    public static AccountRepository provideLogin(){
        AccountDataSourceFactory accountDataSourceFactory = new AccountDataSourceFactory();
        return new AccountRepositoryImpl(accountDataSourceFactory.createCloudDataSource(),
                accountDataSourceFactory.createLocalDataSource()
                );
    }

    public static RetrieveCategoryUseCase provideCategory(){
        return new RetrieveCategoryUseCase(provideAccountRepository());
    }

    public static LoginUseCase executeLogin(){
        return new LoginUseCase(provideLogin());
    }

    public static SaveLoginUsernameUseCase provideSaveUsername() {
        return new SaveLoginUsernameUseCase(provideAccountRepository());
    }

    public static SaveAccountDataUseCase provideSaveAccountData(){
        return new SaveAccountDataUseCase(provideAccountRepository());
    }

}
