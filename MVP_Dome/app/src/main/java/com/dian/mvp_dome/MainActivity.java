package com.dian.mvp_dome;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dian.mvp_dome.base.BaseMvpActivity;
import com.dian.mvp_dome.bean.BaseObjectBean;
import com.dian.mvp_dome.bean.LoginBean;
import com.dian.mvp_dome.mvp.contract.LoginContract;
import com.dian.mvp_dome.mvp.presenter.LoginPresenter;
import com.dian.mvp_dome.utils.ProgressDialog;

import org.jetbrains.annotations.Contract;

public class MainActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {
    private TextInputEditText mEtUsernameLogin;
    private TextInputEditText mEtPasswordLogin;
    private Button mBtnSigninLogin;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);

        mEtUsernameLogin = (TextInputEditText) findViewById(R.id.et_username_login);
        mEtPasswordLogin = (TextInputEditText) findViewById(R.id.et_password_login);
        mBtnSigninLogin = (Button) findViewById(R.id.btn_signin_login);

        mBtnSigninLogin.setOnClickListener(this);
    }

    @Override
    public void onSuccess(BaseObjectBean<LoginBean> bean) {
        int status = bean.getStatus();
        if (status == 0000) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        }else{
            String message = bean.getMessage();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showLoading() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dismiss();
    }

    @Override
    public void onError(Throwable throwable) {
        Log.e("MainActivity:onError", throwable.getMessage());
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signin_login:
                String nameText = mEtUsernameLogin.getText().toString().trim();
                String pwdText = mEtPasswordLogin.getText().toString().trim();
                if (pwdText.isEmpty()||pwdText.isEmpty()) {
                    Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mPresenter.login(nameText, pwdText);
                break;
        }
    }
}
