package com.example.hiennv.mvpanddagger2.presenter;

import com.example.hiennv.mvpanddagger2.contract.MainContract;
import com.example.hiennv.mvpanddagger2.model.Model;

public class MainPresenterImpl implements MainContract.PresenterCallBack,
MainContract.ModelCallBack.OnFinishedListener{
    //Khai báo biến instance của Model và Interface callback view
    private MainContract.ViewCallBack mainView;
    private Model model;

    /*Tạo constructor*/
    public MainPresenterImpl(MainContract.ViewCallBack mainView, Model model) {
        this.mainView = mainView;
        this.model = model;
    }

    @Override
    public void onFinised(String str) {
        if (mainView != null){
            mainView.setQuotes(str);
            mainView.hideProgress();
        }
    }

    @Override
    public void onButtonClick() {
        //Sự kiện click
        if (mainView != null){
            //Show progressbar
            mainView.showProgress();
        }
        model.getNextQuote(this);
    }

    @Override
    public void onDestroy() {
        //Giải phóng mainview
        if (mainView != null){
            mainView = null;
        }
    }
}
