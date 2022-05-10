package com.mwaibanda.recycleviewretrofit.di;

import com.mwaibanda.recycleviewretrofit.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class, ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
