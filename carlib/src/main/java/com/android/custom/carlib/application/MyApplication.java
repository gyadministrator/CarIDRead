package com.android.custom.carlib.application;

import android.app.Application;

import androidx.multidex.MultiDex;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @ProjectName: CarIDRead
 * @Package: com.android.custom.carlib.application
 * @ClassName: MyApplication
 * @Author: 1984629668@qq.com
 * @CreateDate: 2020/12/22 14:30
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .build();
        OkHttpUtils.initClient(okHttpClient);

        // 主要是添加下面这句代码
        MultiDex.install(this);
    }
}
