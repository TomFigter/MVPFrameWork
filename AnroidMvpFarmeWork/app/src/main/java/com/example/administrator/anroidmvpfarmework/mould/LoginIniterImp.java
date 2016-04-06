package com.example.administrator.anroidmvpfarmework.mould;

import android.support.v4.app.NavUtils;

import com.example.administrator.anroidmvpfarmework.interactor.AbstractInteractor;
import com.example.administrator.anroidmvpfarmework.interactor.InteractorExecutor;
import com.example.administrator.anroidmvpfarmework.interactor.MainThreadExecutor;

/**
 * 作者：LiShiChuang on 2016/1/16 14:43
 * 邮箱：lschuang@126.com
 */
public class LoginIniterImp extends AbstractInteractor implements LoginIniter {
    private static final int TASK_LOGIN_TYPE = 0x1001;
    private int currentTaskType = -1;
    private Callback callback;
    private String password;
    private String userdata;

    public LoginIniterImp(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor) {
        super(interactorExecutor, mainThreadExecutor);
    }

    @Override
    public void run() {
        if (currentTaskType == TASK_LOGIN_TYPE) {
            dotedit();
        }

    }

    private void dotedit() {
        if (userdata.equals("")) {
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onLoginError("请输入用户名");
                }
            });
        } else if (password.equals("")) {
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onLoginError("请输入密码");
                }
            });
        } else {
            if (userdata.equals("123") && password.equals("123")) {
                getMainThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onLoginSuccess();
                    }
                });

            } else if (!userdata.equals("123")) {
                getMainThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onLoginError("用户名输入有误！请重新输入");
                    }
                });
            } else if (!password.equals("123")) {
                getMainThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onLoginError("密码输入有误！请重新输入");
                    }
                });
            }
        }

    }

    @Override
    public void geteditdata(String userdata, String password, Callback callback) {
        this.userdata = userdata;
        this.password = password;
        this.callback = callback;
        this.currentTaskType = TASK_LOGIN_TYPE;
        getInteractorExecutor().run(this);
    }


}
