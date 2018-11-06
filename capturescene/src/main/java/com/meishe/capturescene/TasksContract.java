package com.meishe.capturescene;

import android.content.Context;

import com.meishe.commonlibrary.BasePresenter;
import com.meishe.commonlibrary.BaseView;

import java.util.List;

/**
 * Created by CaoZhiChao on 2018/11/1 17:39
 */
public interface TasksContract {

    interface View extends BaseView<Presenter> {
        Context getFragmentContext();

        void onCameraDevicesChange(int devicesId);

//        NvsLiveWindow getLiveWindow();

        void initCapture(boolean is2DevicesId);
    }

    interface Presenter extends BasePresenter {

        void onPause();

        List getCaptureSceneList();

        void setFlash();

        void setCameraDevice();
    }
}

