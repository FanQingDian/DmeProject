package com.dian.mvp_dome.mvp.contract;

import com.dian.mvp_dome.base.BaseView;
import com.dian.mvp_dome.bean.BaseObjectBean;
import com.dian.mvp_dome.bean.LoginBean;

import io.reactivex.Flowable;

public interface LoginContract {
    interface Model {
        Flowable<BaseObjectBean<LoginBean>> login(String username, String password);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BaseObjectBean<LoginBean> bean);
    }

    interface Presenter {
        void login(String username, String password);
    }
}
