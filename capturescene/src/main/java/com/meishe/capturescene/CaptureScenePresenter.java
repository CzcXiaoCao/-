package com.meishe.capturescene;

import android.support.annotation.NonNull;

import com.meishe.commonlibrary.chouxiang.BaseMvpPresenter;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by CaoZhiChao on 2018/11/1 18:08
 */
public class CaptureScenePresenter extends BaseMvpPresenter<TasksContract.View> implements TasksContract.Presenter {
    private final String TAG = "CaptureScenePresenter";
    private final TasksContract.View mTasksView;
    private List<String> mCaptureSceneList;
//    private NvsStreamingContext mStreamingContext;
//    private NvsLiveWindow mLiveWindow;
    private int mCurrentDeviceIndex = 0;
    public CaptureScenePresenter(@NonNull TasksContract.View tasksView) {
        mTasksView = checkNotNull(tasksView, "tasksView cannot be null!");
//        mTasksView.setPresenter(this);
    }

    @Override
    public void onPause() {

    }

    @Override
    public List getCaptureSceneList() {
        return null;
    }

    @Override
    public void setFlash() {

    }

    @Override
    public void setCameraDevice() {

    }

    @Override
    public void start() {

    }
//
//    private NvsStreamingContext getNvStreamingContext() {
//        if (mStreamingContext == null) {
//            mStreamingContext = NvsStreamingContext.getInstance();
//        }
//        return mStreamingContext;
//    }
//    private void initCapture() {
//        if (null == mStreamingContext) {
//            return;
//        }
//        mStreamingContext.getAssetPackageManager().setCallbackInterface(this);
//        if (mStreamingContext.getCaptureDeviceCount() == 0) {
//            return;
//        }
//        if (!mStreamingContext.connectCapturePreviewWithLiveWindow(mLiveWindow)) {
//            Log.e(TAG, "Failed to connect capture preview with livewindow!");
//            return;
//        }
//        mTasksView.initCapture(mStreamingContext.getCaptureDeviceCount() > 1);
//        startCapturePreview(false);
//    }
//
//    // 获取当前引擎状态
//    private int getCurrentEngineState() {
//        return mStreamingContext.getStreamingEngineState();
//    }
//
//    private void startCapturePreview(boolean deviceChanged) {
//        int captureResolutionGrade = NvsStreamingContext.VIDEO_CAPTURE_RESOLUTION_GRADE_HIGH;
//        if ( (deviceChanged || getCurrentEngineState() != NvsStreamingContext.STREAMING_ENGINE_STATE_CAPTUREPREVIEW)) {
//            if (!mStreamingContext.startCapturePreview(mCurrentDeviceIndex,
//                    captureResolutionGrade,
//                    NvsStreamingContext.STREAMING_ENGINE_CAPTURE_FLAG_GRAB_CAPTURED_VIDEO_FRAME, null)) {
//                Log.e(TAG, "Failed to start capture preview!");
//            }
//        }
//    }
//    @Override
//    public void start() {
//        getNvStreamingContext();
//        mLiveWindow = mTasksView.getLiveWindow();
//        initCapture();
//        mCaptureSceneList = new ArrayList<>();
//        getMessageFormAssetsFile();
//    }
//
//    private void getMessageFormAssetsFile() {
//        try {
//            String[] path_list = mTasksView.getFragmentContext().getAssets().list("capturescene");
//            if (path_list != null) {
//                mCaptureSceneList = Arrays.asList(path_list);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onPause() {
//        if(mStreamingContext != null){
//            mStreamingContext.stop();
//        }
//    }
//
//    @Override
//    public List<String> getCaptureSceneList() {
//        return mCaptureSceneList;
//    }
//
//    @Override
//    public void setFlash() {
//        mStreamingContext.toggleFlash(!mStreamingContext.isFlashOn());
//    }
//
//    @Override
//    public void setCameraDevice() {
//        mCurrentDeviceIndex = mCurrentDeviceIndex == 0 ? 1 : 0;
//        if (mStreamingContext.isCaptureDeviceBackFacing(mCurrentDeviceIndex)) {
//            mTasksView.onCameraDevicesChange(mCurrentDeviceIndex);
//        } else {
//            if (mStreamingContext.isFlashOn()) {
//                mStreamingContext.toggleFlash(false);
//            }
//        }
//        startCapturePreview(true);
//    }
//
//    @Override
//    public void onFinishAssetPackageInstallation(String s, String s1, int i, int i1) {
//
//    }
//
//    @Override
//    public void onFinishAssetPackageUpgrading(String s, String s1, int i, int i1) {
//
//    }
}
