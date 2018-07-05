package com.example.hiennv.mvpanddagger2.di.module;

import android.app.Application;

import com.example.hiennv.mvpanddagger2.application.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    //Cung cấp Applicaiotn
    private MyApplication myApplication;


    public AppModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return myApplication;
    }
}
