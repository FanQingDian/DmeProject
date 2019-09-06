package com.dian.mvp_dome.mvp.model;

import com.dian.mvp_dome.api.RetrofitClient;
import com.dian.mvp_dome.bean.BaseObjectBean;
import com.dian.mvp_dome.bean.LoginBean;
import com.dian.mvp_dome.mvp.contract.LoginContract;

import io.reactivex.Flowable;

public class LoginModel implements LoginContract.Model {
    @Override
    public Flowable<BaseObjectBean<LoginBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi().login(username,password);
    }
}
