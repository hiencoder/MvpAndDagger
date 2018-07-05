package com.example.hiennv.mvpanddagger2.application;

import android.app.Application;
import android.content.Context;

import com.example.hiennv.mvpanddagger2.di.component.AppComponent;
import com.example.hiennv.mvpanddagger2.di.component.DaggerAppComponent;
import com.example.hiennv.mvpanddagger2.di.module.AppModule;
import com.example.hiennv.mvpanddagger2.di.module.ContextModule;
import com.example.hiennv.mvpanddagger2.di.module.DataModule;

public class MyApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .contextModule(new ContextModule(this))
                .dataModule(new DataModule())
                .build();
    }

    //Lấy ra MyApplication
    public static MyApplication getApplication(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    //Lấy ra appComponent khi cấu hình
    public AppComponent getAppComponent() {
        return appComponent;
    }
}
