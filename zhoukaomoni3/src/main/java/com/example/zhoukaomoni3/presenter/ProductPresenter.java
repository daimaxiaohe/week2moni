package com.example.zhoukaomoni3.presenter;

import com.example.zhoukaomoni3.bean.AssorBean;
import com.example.zhoukaomoni3.bean.HomeBean;
import com.example.zhoukaomoni3.contract.Contract;
import com.example.zhoukaomoni3.model.ProductModel;
import com.example.zhoukaomoni3.utils.RequestCallBack;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * はすてすゃの
 * 2019-01-05.
 */
public class ProductPresenter extends Contract.CPresenter {
    private ProductModel model;
    private Contract.IView view;
    public ProductPresenter(Contract.IView view) {
        this.model = new ProductModel();
        this.view = view;
    }
    //左边的展示
    @Override
    public void showleft(String uri) {
        model.showleft(uri, new RequestCallBack() {
            @Override
            public void success(String result) {
                if (view!=null&&result!=null){
                    HomeBean homeBean = new Gson().fromJson(result, HomeBean.class);
                    view.success(homeBean.data);
                }
            }

            @Override
            public void fail(String error) {
                view.error(error);
            }

            @Override
            public void rightsuccess(String result) {

            }
        });
    }
    //右边的展示
    @Override
    public void showright(String uri, HashMap<String,String> map) {
        model.showright(uri, map, new RequestCallBack() {
            @Override
            public void success(String result) {

            }

            @Override
            public void fail(String error) {
                    view.error(error);
            }

            @Override
            public void rightsuccess(String result) {
                if (view!=null&&result!=null){
                    AssorBean assorBean = new Gson().fromJson(result, AssorBean.class);
                    view.rightsuccess(assorBean.data);
                }
            }
        });
    }
}
