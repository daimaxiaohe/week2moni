package com.example.zhoukaomoni3.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * はすてすゃの
 * 2019-01-05.
 */
public class OkhttpUtil {
    OkHttpClient okhttp;
    /**
     *     设置单例模式
     */
    private static OkhttpUtil minstance;
    //私有的构造方法
    private OkhttpUtil(){
        //设置日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        //okhttp
        okhttp = new OkHttpClient.Builder()
                //添加日志拦截器
                .addInterceptor(interceptor)
                .addNetworkInterceptor(interceptor)
                //设置超时时间
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    /**
     * 设置单例方法
     * @return
     */
    public static OkhttpUtil getMinstance(){
        if (minstance==null){
            synchronized(OkhttpUtil.class){
                if (minstance==null){
                    minstance =new OkhttpUtil();
                }
            }
        }
        return minstance;
    }
    /**
     * post请求方法
     */
    public void doget(String uri, final OkhttpCallBack callBack){
        //请求的对象
        Request request = new Request.Builder().url(uri).get().build();
        //call
        okhttp.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callBack!=null){
                    callBack.fail("网络请求失败");
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callBack!=null){
                    callBack.success(response.body().string());
                }
            }
        });
    }
    /**
     * post请求方法
     */
    public void dopost(String uri,HashMap<String,String> map, final OkhttpCallBack callBack){
        //原生表单的类
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> p : map.entrySet()) {
            builder.add(p.getKey(),p.getValue());
        }
        //请求的对象
        Request request = new Request.Builder().url(uri).post(builder.build()).build();
        //call
        okhttp.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callBack!=null){
                    callBack.fail("网络请求失败");
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callBack!=null){
                    callBack.success(response.body().string());
                }
            }
        });
    }
    public void setcancle(){
        if (okhttp!=null){
            okhttp.dispatcher().cancelAll();
        }
    }
}
