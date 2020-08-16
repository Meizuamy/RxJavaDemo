package com.example.umapplication;

import android.app.Application;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

public class UMApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        /**
         * 注意: 即使您已经在AndroidManifest.xml中配置过appkey和channel值，也需要在App代码中调
         * 用初始化接口（如需要使用AndroidManifest.xml中配置好的appkey和channel值，
         * UMConfigure.init调用中appkey和channel参数请置为null）。
         */
        // UMConfigure.init(Context context, String appkey, String channel, int deviceType, String pushSecret);

        // 初始化SDK
        // 第二个参数是从账号获得的hashcode
        UMConfigure.init(this,"5f2ffeacd309322154763d6c","umeng",UMConfigure.DEVICE_TYPE_PHONE,null);
        // 选用Auto页面采集模式
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);

        /**
         * 设置组件化的Log开关
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        UMConfigure.setLogEnabled(true);
    }
}
