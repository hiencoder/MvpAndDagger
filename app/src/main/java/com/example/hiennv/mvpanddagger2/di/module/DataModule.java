package com.example.hiennv.mvpanddagger2.di.module;

import com.example.hiennv.mvpanddagger2.model.Model;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    @Provides
    public Model provideModel(){
        return new Model();
    }
}
