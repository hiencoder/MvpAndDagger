package com.example.hiennv.mvpanddagger2.di.module;

import com.example.hiennv.mvpanddagger2.contract.MainContract;
import com.example.hiennv.mvpanddagger2.model.Model;
import com.example.hiennv.mvpanddagger2.presenter.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MvpModule {
    private MainContract.ViewCallBack mainView;

    public MvpModule(MainContract.ViewCallBack mainView) {
        this.mainView = mainView;
    }

    //Cung cấp MainView
    @Provides
    public MainContract.ViewCallBack provideMainView(){
        return mainView;
    }

    //Cung cấp PresenterCallBack
    @Provides
    public MainContract.PresenterCallBack providePresenter(MainContract.ViewCallBack viewCallBack, Model model){
        return new MainPresenterImpl(viewCallBack,model);
    }
}
