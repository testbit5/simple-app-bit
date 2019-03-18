package com.example.restapipractice;

import com.example.restapipractice.data.source.AccountDataSource;
import com.example.restapipractice.data.source.cloud.CloudAccountDataSource;
import com.example.restapipractice.data.source.factory.AccountDataSourceFactory;
import com.example.restapipractice.domain.repository.AccountRepository;
import com.example.restapipractice.domain.repository.AccountRepositoryImpl;
import com.example.restapipractice.domain.usecase.RetrieveCategoryUseCase;

@SuppressWarnings("ALL")
public class ApplicationComponent {
    private ApplicationComponent(){}

    private static AccountRepository provideAccountRepository(){
        AccountDataSourceFactory accountDataSourceFactory = new AccountDataSourceFactory();

        return new AccountRepositoryImpl(accountDataSourceFactory.createCloudDataSource(),
               accountDataSourceFactory.createLocalDataSource()
        );
    }
    public static RetrieveCategoryUseCase provideCategory(){
        return new RetrieveCategoryUseCase(provideAccountRepository());
    }
}
