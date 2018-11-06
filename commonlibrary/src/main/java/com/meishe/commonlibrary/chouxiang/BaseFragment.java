package com.meishe.commonlibrary.chouxiang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.meishe.commonlibrary.BaseView;
import com.meishe.commonlibrary.chouxiang.BaseMvpPresenter;

/**
 * Created by CaoZhiChao on 2018/11/2 15:21
 */
public abstract class BaseFragment<V extends BaseView, P extends BaseMvpPresenter<V>> extends Fragment {
    private P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null) {
            presenter = createPresenter();
        }

        if (presenter == null) {
            throw new NullPointerException("presenter 不能为空!");
        }
        //绑定view
        presenter.onAttachMvpView((V) this);
    }

    /**
     * 创建Presenter
     *
     * @return 子类自己需要的Presenter
     */
    protected abstract P createPresenter();

    public P getPresenter() {
        return presenter;
    }
}
