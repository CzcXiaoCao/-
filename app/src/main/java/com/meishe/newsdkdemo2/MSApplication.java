package com.meishe.newsdkdemo2;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;


/**
 * Created by ${gexinyu} on 2018/5/24.
 */

public class MSApplication extends Application {
    private static Context mContext;

    public static Context getmContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        //初始化
        String licensePath = "assets:/meishesdk.lic";
//        NvsStreamingContext.init(mContext, licensePath, NvsStreamingContext.STREAMING_CONTEXT_FLAG_SUPPORT_4K_EDIT);

        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
