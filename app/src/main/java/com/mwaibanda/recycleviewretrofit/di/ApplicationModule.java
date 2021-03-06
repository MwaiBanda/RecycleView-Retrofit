package com.mwaibanda.recycleviewretrofit.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class ApplicationModule {
   Application application;

   public ApplicationModule(Application application) {
       this.application = application;
   }

   @Provides
    @Singleton
    Application provideApplication(){
       return application;
   }
}
