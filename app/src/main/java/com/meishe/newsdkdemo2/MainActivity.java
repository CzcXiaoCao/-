package com.meishe.newsdkdemo2;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.meishe.annotation.BindView;
import com.meishe.annotation.Code;
import com.meishe.annotation.Print;
import com.meishe.capturescene.CaptureScenePresenter;
import com.meishe.commonlibrary.chouxiang.BaseFragment;
import com.meishe.commonlibrary.util.ActivityUtils;
import com.meishe.newsdkdemo2.utils.FragmentUtils;

import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks, View.OnClickListener{
    private final String TAG = getClass().getName();
    CaptureScenePresenter mTasksPresenter;
    @BindView(id = R.id.textView)
    TextView tv_test;
    public final static String[] PERMS ={Manifest.permission.CAMERA};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bind_MainActivity.bindView(this);
        if (EasyPermissions.hasPermissions(this, PERMS)){
           init();
        }else {
            EasyPermissions.requestPermissions(this, "权限弹窗上的文字提示语。告诉用户，这个权限用途",123,PERMS);
        }
    }
    private void init(){
        BaseFragment tasksFragment =
                (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (tasksFragment == null) {
            // Create the fragment
            tasksFragment = FragmentUtils.getCaptureSceneFragment();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), tasksFragment, R.id.contentFrame);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //将请求结果传递EasyPermission库处理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Toast.makeText(this, "用户授权成功", Toast.LENGTH_SHORT).show();
        init();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Toast.makeText(this, "用户授权失败", Toast.LENGTH_SHORT).show();
        /**
         * 若是在权限弹窗中，用户勾选了'NEVER ASK AGAIN.'或者'不在提示'，且拒绝权限。
         * 这时候，需要跳转到设置界面去，让用户手动开启。
         */
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.textView){
            Log.e(TAG, "onClick: " );
        }
    }
}
