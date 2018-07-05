package com.example.hiennv.mvpanddagger2.contract;

public interface MainContract {
    //Các phương thức callback của view
    interface ViewCallBack{
        //hiển thị progress bar
        void showProgress();
        //Đóng progressbar
        void hideProgress();

        //Thiết lập lại quote hiển thị
        void setQuotes(String quote);
    }

    //Các phương thức callback của model
    //Thông báo sau khi các sự kiện thành công(set quote)
    interface ModelCallBack{
        interface OnFinishedListener{
            void onFinised(String str);
        }

        void getNextQuote(OnFinishedListener onFinishedListener);
    }

    //Các phương thức callback của Presenter
    //Control sự kiện click của button và onDestroy của lifecylce
    interface PresenterCallBack{
        void onButtonClick();

        void onDestroy();
    }
}
