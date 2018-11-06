package com.meishe.newsdkdemo2.utils;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.meishe.commonlibrary.chouxiang.BaseFragment;
import com.meishe.commonlibrary.router.RouteUtils;

/**
 * Created by Administrator on 2017/12/4 0004.
 */

public class FragmentUtils {

    public static BaseFragment getCaptureSceneFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteUtils.CaptureScene_Fragment_Main).navigation();
        return (BaseFragment) fragment;
    }
}