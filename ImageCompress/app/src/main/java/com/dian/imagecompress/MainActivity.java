package com.dian.imagecompress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private ImageView mImgMain;
    String urlString="http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgMain = (ImageView) findViewById(R.id.img_main);
        Glide.with(this)
                .load(urlString)
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .into(new TransformationUtils(mImgMain));
    }
}
