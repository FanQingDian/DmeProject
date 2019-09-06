package com.dian.mvp_dome.mvp.presenter;

import com.dian.mvp_dome.api.RxScheduler;
import com.dian.mvp_dome.base.BasePresenter;
import com.dian.mvp_dome.bean.BaseObjectBean;
import com.dian.mvp_dome.bean.LoginBean;
import com.dian.mvp_dome.mvp.contract.LoginContract;
import com.dian.mvp_dome.mvp.model.LoginModel;

import org.jetbrains.annotations.Contract;

import io.reactivex.functions.Consumer;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    private LoginContract.Model model;

    public LoginPresenter() {
        model = new LoginModel();
    }

    @Override
    public void login(String username, String password) {
        //判断是否与View层绑定  ,  未绑定不执行请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.login(username, password)
                .compose(RxScheduler.<BaseObjectBean<LoginBean>>Flo_io_main())
                .as(mView.<BaseObjectBean<LoginBean>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<LoginBean>>() {
                    @Override
                    public void accept(BaseObjectBean<LoginBean> bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }
}
