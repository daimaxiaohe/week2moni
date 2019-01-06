package com.example.zhoukaomoni3.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zhoukaomoni3.R;
import com.example.zhoukaomoni3.adapter.LeftAdapter;
import com.example.zhoukaomoni3.adapter.RightAdapter;
import com.example.zhoukaomoni3.api.ApiBean;
import com.example.zhoukaomoni3.bean.AssorBean;
import com.example.zhoukaomoni3.bean.HomeBean;
import com.example.zhoukaomoni3.contract.Contract;
import com.example.zhoukaomoni3.presenter.ProductPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * はすてすゃの
 * 2019-01-05.
 */
public class AssorFragment extends Fragment implements Contract.IView{
    @BindView(R.id.left_show)
    RecyclerView recyclerleft;
    @BindView(R.id.right_show)
    RecyclerView recyclerright;
    private String cid="1";
    private ProductPresenter productPresenter;
    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_assor,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        initView(view);
        initData();
    }

    /**
     * 操作视图的方法
     * @param view
     */
    private void initView(View view) {
        //创建一个presenter实例
        productPresenter = new ProductPresenter(this);
        //设置布局模式
        recyclerleft.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerright.setLayoutManager(new LinearLayoutManager(getActivity()));
        //创建适配器 类
        leftAdapter = new LeftAdapter(getActivity());
        rightAdapter = new RightAdapter(getActivity());
        //设置适配器
        recyclerleft.setAdapter(leftAdapter);
        recyclerright.setAdapter(rightAdapter);
    }

    /**
     * 操作数据的方法
     */
    private void initData() {
        getleft();
        getright();
        //左侧适配器的点击方法
        leftAdapter.setItemOnClick(new LeftAdapter.ItemOnClick() {
            @Override
            public void OnClick(String cid1) {
                cid = null;
                cid = cid1;
                getright();
            }
        });
    }
    /**
     * 左侧数据的查询方法
     */
    private void getleft(){
        productPresenter.showleft(ApiBean.LEFT_API);
    }

    /**
     * 右侧的查询方法
     *
     */
    private void getright(){
        HashMap<String,String> map = new HashMap<>();
        map.put("cid",cid);
        productPresenter.showright(ApiBean.RIGHT_API,map);
    }
    @Override
    public void success(List<HomeBean.Datas> list) {
        if (list!=null){
            leftAdapter.setlist(list);
        }
    }

    @Override
    public void error(String error) {
        Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void rightsuccess(List<AssorBean.Product> list) {
        if (list!=null){
            rightAdapter.setlist(list);
        }
    }
    /**
     * 防止内存泄漏
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (productPresenter!=null){
            productPresenter.setcancle();
            productPresenter=null;
        }
    }
}
