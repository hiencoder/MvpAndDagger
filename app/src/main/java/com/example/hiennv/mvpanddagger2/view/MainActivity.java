package com.example.hiennv.mvpanddagger2.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiennv.mvpanddagger2.R;
import com.example.hiennv.mvpanddagger2.application.MyApplication;
import com.example.hiennv.mvpanddagger2.contract.MainContract;
import com.example.hiennv.mvpanddagger2.di.component.DaggerActivityComponent;
import com.example.hiennv.mvpanddagger2.di.module.MvpModule;
import com.example.hiennv.mvpanddagger2.presenter.MainPresenterImpl;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.ViewCallBack{
    @BindView(R.id.tv_quote)
    TextView tvQuote;
    @BindView(R.id.btn_get_quote)
    Button btnGetQuote;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    //Inject presenter
    @Inject
    MainContract.PresenterCallBack presenterCallBack;

    @Inject
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerActivityComponent.builder()
                .appComponent(MyApplication.getApplication(this).getAppComponent())
                .mvpModule(new MvpModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);
        tvQuote.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
        tvQuote.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuotes(String quote) {
        tvQuote.setText(quote);
        Toast.makeText(context, "Update quote", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterCallBack.onDestroy();
    }

    @OnClick(R.id.btn_get_quote)
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_get_quote:
                presenterCallBack.onButtonClick();
                break;
        }
    }
}
