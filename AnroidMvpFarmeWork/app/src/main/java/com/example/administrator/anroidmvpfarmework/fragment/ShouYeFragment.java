package com.example.administrator.anroidmvpfarmework.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.administrator.anroidmvpfarmework.R;
import com.example.administrator.anroidmvpfarmework.parent.ShowYeParent;
import com.example.administrator.anroidmvpfarmework.parent.ShowYeParentImp;
import com.example.administrator.anroidmvpfarmework.setget.ReDianData;
import com.example.administrator.anroidmvpfarmework.view.ShouYeView;

import java.util.List;

/**
 * 作者：LiShiChuang on 2016/1/23 16:21
 * 邮箱：lschuang@126.com
 */
public class ShouYeFragment extends BaseFragment implements ShouYeView, View.OnClickListener {
    public static final String TAG = ShouYeFragment.class.getCanonicalName();
    private View view;
    private RadioButton xinwen_radio;
    private RadioButton redian_radio;
    private LinearLayout xinwen_linner;
    private LinearLayout redian_linner;
    private ListView redian_list;
    private ListView xinwen_list;
    private ShowYeParent showYeParent;

    @Override
    public String getCustomTag() {
        return TAG;
    }

    public static ShouYeFragment newInstance() {
        return new ShouYeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showYeParent=new ShowYeParentImp(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shouye_fragment_layout, container, false);
        xinwen_radio = (RadioButton) view.findViewById(R.id.xinwen);
        redian_radio = (RadioButton) view.findViewById(R.id.redian);
        xinwen_linner=(LinearLayout)view.findViewById(R.id.xinwen_layout);
        redian_linner=(LinearLayout)view.findViewById(R.id.redian_layout);
        xinwen_radio.setOnClickListener(this);
        redian_radio.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v==xinwen_radio){
            showxinwen(xinwen_linner);
        }else if (v==redian_linner){
            showredian(redian_linner);
        }

    }

    /**
     * 显示新闻
     * @param xinwen_linner
     */
    private void showxinwen(LinearLayout xinwen_linner) {
      xinwen_list=(ListView)xinwen_linner.findViewById(R.id.xinwen_data_listview);
      showYeParent.getrediandata();
    }

    /**
     * 显示热点
     * @param redian_linner
     */
    private void showredian(LinearLayout redian_linner) {
        redian_list=(ListView)redian_linner.findViewById(R.id.redian_data_listview);


    }

    @Override
    public void getrdlistdata(List<ReDianData> reDianData) {

    }
}
