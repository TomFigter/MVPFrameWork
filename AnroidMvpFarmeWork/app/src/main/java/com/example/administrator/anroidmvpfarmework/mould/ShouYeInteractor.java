package com.example.administrator.anroidmvpfarmework.mould;

import android.widget.ListView;

import com.example.administrator.anroidmvpfarmework.setget.ReDianData;

import java.util.List;

/**
 * 作者：LiShiChuang on 2016/2/20 14:02
 * 邮箱：lschuang@126.com
 */
public interface ShouYeInteractor {
    void getredianlistdata(Callback callback);
    interface  Callback {
        void getDatalist(List<ReDianData> reDianDataList);
        void getDataSuccess();
        void getDataError(String massage);
    }

}
