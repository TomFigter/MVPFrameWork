package com.example.administrator.anroidmvpfarmework.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.anroidmvpfarmework.R;
import com.example.administrator.anroidmvpfarmework.activity.LSMainActivity;
import com.example.administrator.anroidmvpfarmework.parent.LoginParent;
import com.example.administrator.anroidmvpfarmework.parent.LoginParentImp;
import com.example.administrator.anroidmvpfarmework.view.LoginView;

/**
 * 作者：LiShiChuang on 2016/1/16 16:11
 * 邮箱：lschuang@126.com
 */
public class LoginFragment extends BaseFragment implements LoginView ,View.OnClickListener {
    public static final String TAG=LoginFragment.class.getSimpleName();
    private EditText passwprd_edit;
    private EditText username_edit;
    private Button login_btn;
    private LoginParent parent;

    @Override
    public String getCustomTag() {
        return TAG;
    }

 public static LoginFragment newInstance(){
     return  new LoginFragment();
 }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parent = new LoginParentImp(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragmet_layout, container, false);
        username_edit=(EditText)view.findViewById(R.id.username_edit);
        passwprd_edit=(EditText)view.findViewById(R.id.password_edit);
        login_btn=(Button)view.findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v==login_btn){
            parent.geteditdata(username_edit.getText().toString(),passwprd_edit.getText().toString());
        }
    }

    @Override
    public void onLoginSuccess() {
        Intent intent=new Intent(getActivity(), LSMainActivity.class);
         startActivity(intent);
    }

    @Override
    public void onError(String massage) {
        Toast.makeText(getActivity(),massage,Toast.LENGTH_LONG).show();
    }
}
