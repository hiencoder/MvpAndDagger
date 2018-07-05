package com.example.hiennv.mvpanddagger2.di.component;

import com.example.hiennv.mvpanddagger2.contract.MainContract;
import com.example.hiennv.mvpanddagger2.di.module.MvpModule;
import com.example.hiennv.mvpanddagger2.di.scope.ActivityScope;
import com.example.hiennv.mvpanddagger2.view.MainActivity;

import dagger.Component;

@ActivityScope
@Component(modules = MvpModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    MainContract.PresenterCallBack getMainPresenterCallBack();
}
