package com.example.hiennv.mvpanddagger2.model;

import android.os.Handler;

import com.example.hiennv.mvpanddagger2.contract.MainContract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Model implements MainContract.ModelCallBack{

    @Override
    public void getNextQuote(final OnFinishedListener onFinishedListener) {
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onFinishedListener.onFinised(getRandomQuote());
                    }
                },1200);
    }

    //Tạo quote
    private List<String> listQuote = Arrays.asList(
            "Be yourself. everyone else is already taken.",
            "A room without books is like a body without a soul.",
            "You only live once, but if you do it right, once is enough.",
            "Be the change that you wish to see in the world.",
            "If you tell the truth, you don't have to remember anything."
    );

    //Get random quote
    public String getRandomQuote(){
        int i = (new Random()).nextInt(listQuote.size());
        return listQuote.get(i);
    }
}
