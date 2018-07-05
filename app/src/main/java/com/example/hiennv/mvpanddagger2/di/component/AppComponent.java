package com.example.hiennv.mvpanddagger2.di.component;

import android.app.Application;
import android.content.Context;

import com.example.hiennv.mvpanddagger2.application.MyApplication;
import com.example.hiennv.mvpanddagger2.di.module.AppModule;
import com.example.hiennv.mvpanddagger2.di.module.ContextModule;
import com.example.hiennv.mvpanddagger2.di.module.DataModule;
import com.example.hiennv.mvpanddagger2.di.scope.ActivityScope;
import com.example.hiennv.mvpanddagger2.model.Model;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, ContextModule.class})
public interface AppComponent {

    void inject(MyApplication myApplication);

    Context getContext();

    Model getModel();

    Application getApplication();
}
