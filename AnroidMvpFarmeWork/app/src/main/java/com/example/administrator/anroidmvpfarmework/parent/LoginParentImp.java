package com.example.administrator.anroidmvpfarmework.parent;

import com.example.administrator.anroidmvpfarmework.fragment.LoginFragment;
import com.example.administrator.anroidmvpfarmework.interactor.AbstractInteractor;
import com.example.administrator.anroidmvpfarmework.interactor.Interactor;
import com.example.administrator.anroidmvpfarmework.interactor.InteractorExecutor;
import com.example.administrator.anroidmvpfarmework.interactor.InteractorExecutorImp;
import com.example.administrator.anroidmvpfarmework.interactor.MainThreadExectorImp;
import com.example.administrator.anroidmvpfarmework.interactor.MainThreadExecutor;
import com.example.administrator.anroidmvpfarmework.mould.LoginIniter;
import com.example.administrator.anroidmvpfarmework.mould.LoginIniterImp;
import com.example.administrator.anroidmvpfarmework.view.LoginView;

/**
 * 作者：LiShiChuang on 2016/1/16 14:42
 * 邮箱：lschuang@126.com
 */
public class LoginParentImp implements LoginParent {
    private final LoginView view;
    private  InteractorExecutor interactorExecutor=new InteractorExecutorImp();
    private  MainThreadExecutor mainThreadExecutor=new MainThreadExectorImp();
    private LoginIniter initer=new LoginIniterImp(interactorExecutor,mainThreadExecutor);
    public LoginParentImp(LoginView view) {
        this.view=view;
    }
    LoginIniter.Callback callback= new LoginIniter.Callback() {
        @Override
        public void onLoginSuccess() {
               view.onLoginSuccess();
        }

        @Override
        public void onLoginError(String massage) {
             view.onError(massage);
        }
    };

    @Override
    public void geteditdata(String userdata, String password) {
        initer.geteditdata(userdata,password, callback);
    }
}
