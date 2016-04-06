package com.example.administrator.anroidmvpfarmework.interactor;


import android.os.Handler;
import android.os.Looper;

/**
 * 作者：LiShiChuang on 2016/1/19 21:51
 * 邮箱：lschuang@126.com
 */
public class MainThreadExectorImp implements MainThreadExecutor {
    private Handler handler;
    public MainThreadExectorImp() {
       this.handler=new Handler(Looper.myLooper());
    }
    @Override
    public void execute(Runnable runnable) {
         handler.post(runnable);
    }
}
