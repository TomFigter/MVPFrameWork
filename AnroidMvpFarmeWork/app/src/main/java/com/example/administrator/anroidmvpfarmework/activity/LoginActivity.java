package com.example.administrator.anroidmvpfarmework.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.administrator.anroidmvpfarmework.R;
import com.example.administrator.anroidmvpfarmework.fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//邮箱小圆圈
        initfragment();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initfragment() {
        LoginFragment loginFragment = (LoginFragment) getFragmentManager().findFragmentByTag(LoginFragment.TAG);
       if (null==loginFragment||null!=findViewById(R.id.fragment_layout)){
           loginFragment=loginFragment.newInstance();
           getFragmentManager().beginTransaction().replace(R.id.fragment_layout,loginFragment,LoginFragment.TAG).commit();

       }
    }

}
