package com.example.zhoukaomoni3.model;

import android.os.Handler;

import com.example.zhoukaomoni3.contract.Contract;
import com.example.zhoukaomoni3.utils.OkhttpCallBack;
import com.example.zhoukaomoni3.utils.OkhttpUtil;
import com.example.zhoukaomoni3.utils.RequestCallBack;

import java.util.HashMap;

/**
 * はすてすゃの
 * 2019-01-05.
 */
public class ProductModel implements Contract.IModel {
    Handler handler = new Handler();
    @Override
    public void showleft(String lefturi, final RequestCallBack callBack) {
        OkhttpUtil.getMinstance().doget(lefturi, new OkhttpCallBack() {
            @Override
            public void success(final String result) {
                if (callBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.success(result);
                        }
                    });
                }
            }

            @Override
            public void fail(final String error) {
                if (callBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.success(error);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void showright(String lefturi, HashMap<String,String> map, final RequestCallBack callBack) {
        OkhttpUtil.getMinstance().dopost(lefturi,map, new OkhttpCallBack() {
            @Override
            public void success(final String result) {
                if (callBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.rightsuccess(result);
                        }
                    });
                }
            }

            @Override
            public void fail(final String error) {
                if (callBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.success(error);
                        }
                    });
                }
            }
        });
    }
}
