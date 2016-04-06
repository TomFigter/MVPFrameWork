package com.example.administrator.anroidmvpfarmework.view;

/**
 * 作者：LiShiChuang on 2016/1/16 14:38
 * 邮箱：lschuang@126.com
 */
public interface LoginView extends View {
    void onLoginSuccess();

    void onError(String massage);
}
