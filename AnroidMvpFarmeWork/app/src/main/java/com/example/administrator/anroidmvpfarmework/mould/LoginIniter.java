package com.example.administrator.anroidmvpfarmework.mould;

/**
 * 作者：LiShiChuang on 2016/1/16 14:43
 * 邮箱：lschuang@126.com
 */
public interface LoginIniter {
    void geteditdata(String userdata,String password,final Callback callback);
    interface  Callback{
        void onLoginSuccess();
        void onLoginError(String message);
    }
}
