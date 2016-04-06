package com.example.administrator.anroidmvpfarmework.parent;

import com.example.administrator.anroidmvpfarmework.interactor.InteractorExecutor;
import com.example.administrator.anroidmvpfarmework.interactor.InteractorExecutorImp;
import com.example.administrator.anroidmvpfarmework.interactor.MainThreadExectorImp;
import com.example.administrator.anroidmvpfarmework.interactor.MainThreadExecutor;
import com.example.administrator.anroidmvpfarmework.mould.ShouYeInteractor;
import com.example.administrator.anroidmvpfarmework.mould.ShouYeInteractorImp;
import com.example.administrator.anroidmvpfarmework.mould.LoginIniter;
import com.example.administrator.anroidmvpfarmework.setget.ReDianData;
import com.example.administrator.anroidmvpfarmework.view.ShouYeView;

import java.util.List;

/**
 * 作者：LiShiChuang on 2016/2/20 13:45
 * 邮箱：lschuang@126.com
 */
public class ShowYeParentImp implements ShowYeParent {
    private final ShouYeView view;
    private InteractorExecutor interactorExecutor=new InteractorExecutorImp();
    private MainThreadExecutor mainThreadExecutor=new MainThreadExectorImp();
    private ShouYeInteractor initer=new ShouYeInteractorImp(interactorExecutor,mainThreadExecutor);
    public ShouYeInteractor.Callback callback=new ShouYeInteractor.Callback() {
        @Override
        public void getDatalist(List<ReDianData> reDianDataList) {
            view.getrdlistdata(reDianDataList);
        }

        @Override
        public void getDataSuccess() {

        }

        @Override
        public void getDataError(String massage) {

        }
    };
    public ShowYeParentImp(ShouYeView view){
        this.view=view;
    }
    @Override
    public void getrediandata() {
       initer.getredianlistdata(callback);
    }
}
