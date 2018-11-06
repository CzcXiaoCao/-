package com.meishe.capturescene;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.meishe.commonlibrary.chouxiang.BaseFragment;
import com.meishe.commonlibrary.router.RouteUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by CaoZhiChao on 2018/11/1 17:38
 */
@Route(path = RouteUtils.CaptureScene_Fragment_Main)
public class CaptureSceneFragment extends BaseFragment<TasksContract.View,CaptureScenePresenter> implements TasksContract.View, View.OnClickListener {

    private TasksContract.Presenter mPresenter;
    private TextView switchText;
    private TextView flashText;
    private TextView backgroundText;
//    private NvsLiveWindow mLiveWindow;
//    private ImageView closeButton_cs;
//    private NvsStreamingContext mStreamingContext;
    private boolean mPermissionGranted;
    private List<String> mAllRequestPermission = new ArrayList<>();
    private List mCaptureSceneList = new ArrayList();
    private RadioGroup radioGroup;
    private RadioButton csRadioButton1;
    private RadioButton csRadioButton2;
    private LinearLayout csLayoutBackground;

    public CaptureSceneFragment() {
        // Requires empty public constructor
    }

    public static CaptureSceneFragment newInstance() {
        return new CaptureSceneFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 创建Presenter
     *
     * @return 子类自己需要的Presenter
     */
    @Override
    protected CaptureScenePresenter createPresenter() {
        return new CaptureScenePresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter = getPresenter();
        mPresenter.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

//    @Override
//    public void setPresenter(@NonNull TasksContract.Presenter presenter) {
//        mPresenter = checkNotNull(presenter);
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        mPresenter.result(requestCode, resultCode);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.capturescene_fragment_main, container, false);
//        mLiveWindow = (NvsLiveWindow) root.findViewById(R.id.liveWindow);
//        switchText = (TextView) root.findViewById(R.id.captureScene_switch);
//        flashText = (TextView) root.findViewById(R.id.captureScene_flash);
//        backgroundText = (TextView) root.findViewById(R.id.captureScene_background);
//        closeButton_cs = (ImageView) root.findViewById(R.id.closeButton_cs);
//        radioGroup = (RadioGroup) root.findViewById(R.id.cs_radioGroup);
//        csRadioButton1 = (RadioButton) root.findViewById(R.id.cs_radioButton1);
//        csRadioButton2 = (RadioButton) root.findViewById(R.id.cs_radioButton2);
//        csLayoutBackground = (LinearLayout) root.findViewById(R.id.cs_layout_background);
//        setClick(switchText, flashText, backgroundText, closeButton_cs);
        return root;
    }

    private void setClick(View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
    }

    @Override
    public Context getFragmentContext() {
        return getContext();
    }

    @Override
    public void onCameraDevicesChange(int devicesId) {
        flashText.setEnabled(devicesId == 0);
        flashText.setAlpha(devicesId == 0 ? 1f : 0.5f);
    }

//    @Override
//    public NvsLiveWindow getLiveWindow() {
//        return mLiveWindow;
//    }

    @Override
    public void initCapture(boolean is2DevicesId) {
        switchText.setEnabled(is2DevicesId);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.captureScene_switch) {
            mPresenter.setCameraDevice();
        }
        if (v.getId() == R.id.closeButton_cs) {
            getActivity().finish();
        }
        if (v.getId() == R.id.captureScene_flash) {
            mPresenter.setFlash();
        }
        if (v.getId() == R.id.captureScene_background) {
            csLayoutBackground.setVisibility(csLayoutBackground.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        }
    }
}
