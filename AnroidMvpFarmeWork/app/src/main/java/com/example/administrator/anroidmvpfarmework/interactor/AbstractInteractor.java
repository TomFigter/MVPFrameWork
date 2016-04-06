package com.example.administrator.anroidmvpfarmework.interactor;

/**
 * 作者：LiShiChuang on 2016/1/19 21:16
 * 邮箱：lschuang@126.com
 */
public abstract class AbstractInteractor implements Interactor{
    private  InteractorExecutor interactorExecutor;
    private  MainThreadExecutor mainThreadExecutor;
    public AbstractInteractor(InteractorExecutor interactorExecutor,MainThreadExecutor mainThreadExecutor){
        this.interactorExecutor=interactorExecutor;
        this.mainThreadExecutor=mainThreadExecutor;
    }
    public InteractorExecutor getInteractorExecutor() {
        return interactorExecutor;
    }

    public void setInteractorExecutor(InteractorExecutor interactorExecutor) {
        this.interactorExecutor = interactorExecutor;
    }

    public MainThreadExecutor getMainThreadExecutor() {
        return mainThreadExecutor;
    }

    public void setMainThreadExecutor(MainThreadExecutor mainThreadExecutor) {
        this.mainThreadExecutor = mainThreadExecutor;
    }



}
