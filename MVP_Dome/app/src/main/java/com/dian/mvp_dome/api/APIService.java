package com.dian.mvp_dome.api;

import com.dian.mvp_dome.bean.BaseObjectBean;
import com.dian.mvp_dome.bean.LoginBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST(APIConfig.LOGIN_URL)
    Flowable<BaseObjectBean<LoginBean>> login(@Field("phone") String username,
                                              @Field("pwd") String password);
}
