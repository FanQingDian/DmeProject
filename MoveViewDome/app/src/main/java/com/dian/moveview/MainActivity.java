package com.dian.moveview;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ImageView iv_dv_view;
    private int sx;
    private int sy;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        sp = this.getSharedPreferences("config", Context.MODE_PRIVATE);
        iv_dv_view = (ImageView) this.findViewById(R.id.iv_dv_view);
        iv_dv_view.setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            // 如果手指放在imageView上拖动
            case R.id.iv_dv_view:
                // event.getRawX(); //获取手指第一次接触屏幕在x方向的坐标
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:// 获取手指第一次接触屏幕
                        sx = (int) event.getRawX();
                        sy = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:// 手指在屏幕上移动对应的事件
                        int x = (int) event.getRawX();
                        int y = (int) event.getRawY();
                        // 获取手指移动的距离
                        int dx = x - sx;
                        int dy = y - sy;
                        // 得到imageView最开始的各顶点的坐标
                        int l = iv_dv_view.getLeft();
                        int r = iv_dv_view.getRight();
                        int t = iv_dv_view.getTop();
                        int b = iv_dv_view.getBottom();
                        // 更改imageView在窗体的位置
                        iv_dv_view.layout(l + dx, t + dy, r + dx, b + dy);
                        // 获取移动后的位置
                        sx = (int) event.getRawX();
                        sy = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_UP:// 手指离开屏幕对应事件
                        // 记录最后图片在窗体的位置
                        int lasty = iv_dv_view.getTop();
                        int lastx = iv_dv_view.getLeft();
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("lasty", lasty);
                        editor.putInt("lastx", lastx);
                        editor.commit();
                        break;
                }
                break;
        }
        return true;// 不会中断触摸事件的返回
    }

}
