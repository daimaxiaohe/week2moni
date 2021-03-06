package com.weidu.mall.platform.contract;

import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;
import com.example.lib_core.net.OkhttpCallback;
import com.weidu.mall.platform.model.ProductModel;

import java.util.HashMap;

/**
 * 商品相关契约类
 */
public interface ProductContract {

    abstract class ProductPresenter extends BasePresenter<IProductModel,IProductView>{

        @Override
        public IProductModel getModel() {
            return new ProductModel();
        }

        public abstract void getProductList(HashMap<String, String> params);
    }

    interface IProductModel extends IBaseModel{

        void getProductList(HashMap<String,String> params, ProductModel.IProductCallback callback);

    }

    interface IProductView extends IBaseView{

        void success(String result);
        void keywordsEmpty(String error);

    }
}
