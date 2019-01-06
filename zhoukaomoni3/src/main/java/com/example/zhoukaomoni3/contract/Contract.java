package com.example.zhoukaomoni3.contract;

import com.example.zhoukaomoni3.bean.AssorBean;
import com.example.zhoukaomoni3.bean.HomeBean;
import com.example.zhoukaomoni3.utils.RequestCallBack;

import java.util.HashMap;
import java.util.List;

/**
 * はすてすゃの
 * 2019-01-05.
 */
public interface Contract {
    //定义一个抽象类
    abstract class CPresenter{
       public abstract void showleft(String uri);
       public abstract void showright(String uri, HashMap<String,String> map);
    }
    //定义一个view层接口
    interface IView{
        void success(List<HomeBean.Datas> list);
        void error(String error);
        void rightsuccess(List<AssorBean.Product> list);
    }
    //定义一个model层接口
    interface IModel{
        void showleft(String lefturi, RequestCallBack callBack);
        void showright(String lefturi, HashMap<String,String> map, RequestCallBack callBack);
    }
}
