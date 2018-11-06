package com.meishe.commonlibrary.yunxingshi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by CaoZhiChao on 2018/8/17 10:27
 */
public class ButterKnife {
    public static void initViews(Object object, View view) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            ViewInject viewInject = field.getAnnotation(ViewInject.class);
            if (viewInject != null) {
                int viewId = viewInject.id();
                boolean clickable = viewInject.clickable();
                if (viewId != -1) {
                    try {
                        field.setAccessible(true);
                        field.set(object, view.findViewById(viewId));
                        if (clickable == true) {
                            view.findViewById(viewId).setOnClickListener((View.OnClickListener) object);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    @SuppressLint("NewApi")
    public static void initLayout(Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        ContentView contentView = activityClass.getAnnotation(ContentView.class);
        if (contentView != null) {
            int layoutId = contentView.value();
            try {
                Method method = activityClass.getMethod("setContentView", int.class);
                method.invoke(activity, layoutId);
            } catch ( NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void init(Activity activity) {
        initLayout(activity);
        initViews(activity,activity.getWindow().getDecorView());
    }
}
