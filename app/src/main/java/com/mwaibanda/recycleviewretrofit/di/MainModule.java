package com.mwaibanda.recycleviewretrofit.di;

import com.mwaibanda.recycleviewretrofit.MainViewModel;
import com.mwaibanda.recycleviewretrofit.data.remote.CountryRepositoryImpl;
import com.mwaibanda.recycleviewretrofit.data.remote.CountryService;
import com.mwaibanda.recycleviewretrofit.domain.repository.CountryRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MainModule {
    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttp() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient.Builder httpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://countriesnow.space/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Provides
    @Singleton
    CountryService provideCountryService(Retrofit retrofit) {
        return retrofit.create(CountryService.class);
    }

    @Provides
    @Singleton
    CountryRepository provideCountryRepo(CountryService service) {
        return new CountryRepositoryImpl(service);
    }

    @Provides
    @Singleton
    MainViewModel provideMainVM(CountryRepository repository) {
        return new MainViewModel(repository);
    }
}
