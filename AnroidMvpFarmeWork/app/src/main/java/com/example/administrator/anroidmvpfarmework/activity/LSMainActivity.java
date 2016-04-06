package com.example.administrator.anroidmvpfarmework.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.administrator.anroidmvpfarmework.R;
import com.example.administrator.anroidmvpfarmework.fragment.BaseFragment;
import com.example.administrator.anroidmvpfarmework.fragment.ShouYeFragment;
import com.example.administrator.anroidmvpfarmework.view.LSView;

public class LSMainActivity extends AppCompatActivity implements View.OnClickListener, LSView {

    private RelativeLayout lsc_layout;
    private RadioButton zhanghu_radio;
    private RadioButton touzi_radio;
    private RadioButton shouye_radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsmain);
        lsc_layout = (RelativeLayout) findViewById(R.id.lsmain_layout);
        shouye_radio = (RadioButton) lsc_layout.findViewById(R.id.radio_shouye);
        touzi_radio = (RadioButton) lsc_layout.findViewById(R.id.radio_tpuzi);
        zhanghu_radio = (RadioButton) lsc_layout.findViewById(R.id.radio_username);
        shouye_radio.setOnClickListener(this);
        touzi_radio.setOnClickListener(this);
        zhanghu_radio.setOnClickListener(this);
        switchToFragment(ShouYeFragment.TAG);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    private void switchToFragment(String tag) {
        Fragment to=getFragmentManager().findFragmentByTag(tag);
        ShouYeFragment shouyefragment = (ShouYeFragment) getFragmentManager().findFragmentByTag(ShouYeFragment.TAG);
        FragmentTransaction transation = getFragmentManager().beginTransaction();
        if (ShouYeFragment.TAG.equals(tag)){
            if (null==to||!to.isAdded()){
                to=ShouYeFragment.newInstance();
                transation.add(R.id.ls_fragment_layout,to,((BaseFragment)to).getCustomTag());
            }else{
                transation.show(to);
            }
            transation.commit();
        }
    }

    @Override
    public void onClick(View v) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lsmain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
