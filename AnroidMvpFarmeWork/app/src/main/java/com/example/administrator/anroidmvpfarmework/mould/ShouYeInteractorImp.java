package com.example.administrator.anroidmvpfarmework.mould;

import android.util.Log;

import com.example.administrator.anroidmvpfarmework.httpinterface.HttpAnscy;
import com.example.administrator.anroidmvpfarmework.interactor.AbstractInteractor;
import com.example.administrator.anroidmvpfarmework.interactor.InteractorExecutor;
import com.example.administrator.anroidmvpfarmework.interactor.MainThreadExecutor;
import com.example.administrator.anroidmvpfarmework.mould.ShouYeInteractor;
import com.example.administrator.anroidmvpfarmework.setget.ReDianData;
import com.example.administrator.anroidmvpfarmework.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：LiShiChuang on 2016/2/20 14:01
 * 邮箱：lschuang@126.com
 */
public class ShouYeInteractorImp extends AbstractInteractor implements ShouYeInteractor {
    private Callback callback;
    private static final int SHOUYE_REDIAN=0x1001;
    private  static int currentType=0;
    private List<ReDianData> redianlist;

    public ShouYeInteractorImp(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor) {
        super(interactorExecutor,mainThreadExecutor);
    }

    @Override
    public void run() {
        if (currentType==SHOUYE_REDIAN){
            dorediandata();
        }

    }

    private void dorediandata() {
        redianlist=new ArrayList<>();
        try{
            HttpAnscy httpAnscy=new HttpAnscy();
            redianlist=httpAnscy.sendRequesWithHttpClient();
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    Log.i("得到的数据",""+redianlist);
                    callback.getDatalist(redianlist);
                }
            });
        }catch (Exception e){
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.getDataError("数据请求失败！");
                }
            });
        }
    }

    @Override
    public void getredianlistdata(Callback callback) {
      this.callback=callback;
        currentType=SHOUYE_REDIAN;
        getInteractorExecutor().run(this);
    }
}
