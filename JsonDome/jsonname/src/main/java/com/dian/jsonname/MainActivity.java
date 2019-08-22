package com.dian.jsonname;

import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

    /*
     *从Raw目录下读取json文件
     * 当没有数据头的纯数组JSON情况
     * 作者  @QingDian_Fan
     */
public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecy = (RecyclerView) findViewById(R.id.recy);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecy.setLayoutManager(manager);
        String strByJson = JsonToStringUtil.getStringByJson(this, R.raw.dian);
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonArray jsonArray = parser.parse(strByJson).getAsJsonArray();
        Gson gson = new Gson();
        ArrayList<Bean> mList = new ArrayList<>();
        for (JsonElement user : jsonArray) {
            //使用GSON，直接转成Bean对象
            Bean userBean = gson.fromJson(user, Bean.class);
            mList.add(userBean);
        }

        MyAdapter mAdapter = new MyAdapter(this, mList);
        mRecy.setAdapter(mAdapter);
    }
}
