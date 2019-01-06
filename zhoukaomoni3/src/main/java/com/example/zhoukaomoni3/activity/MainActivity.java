package com.example.zhoukaomoni3.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhoukaomoni3.R;
import com.example.zhoukaomoni3.contract.Contract;
import com.example.zhoukaomoni3.fragment.AssorFragment;
import com.example.zhoukaomoni3.fragment.HomeFragment;
import com.example.zhoukaomoni3.presenter.ProductPresenter;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.tab_bom)
    BottomTabBar bottomTabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }
    /**
     *操作数据的方法
     */
    private void initView() {
        //添加fragment
        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("首页",R.drawable.home,HomeFragment.class)
                .addTabItem("分类",R.drawable.assor,AssorFragment.class);
    }
    /**
     * 操作数据的方法
     */
    private void initData() {

    }
}
