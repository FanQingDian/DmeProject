package com.dian.jsondome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    /*
     *从assets目录下读取json字符串
     *key值不确定的情况下解析
     *作者   @QingDian_Fan
     */
public class MainActivity extends AppCompatActivity {
    private List<Bean> list=new ArrayList<>();
    private RecyclerView mRecy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecy = (RecyclerView) findViewById(R.id.recy);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecy.setLayoutManager(manager);

        StringBuilder newstringBuilder = new StringBuilder();
        InputStream inputStream = null;
        try {
            inputStream = getResources().getAssets().open("dian.json");
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            String jsonLine;
            while ((jsonLine = reader.readLine()) != null) {
                newstringBuilder.append(jsonLine);
            }
            reader.close();
            isr.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = newstringBuilder.toString();
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);//json数据
            JSONObject data = jsonObject.getJSONObject("attImageMap");
            Iterator<String> iterator = data.keys();//使用迭代器
            while (iterator.hasNext()) {
                String key = iterator.next();//获取key
                String value = data.getString(key);//获取value
                Bean bean = gson.fromJson(value, Bean.class);
                list.add(bean);
                Log.e("key-value","key="+key+" value="+value);
            }
            MyAdapter mAdapter = new MyAdapter(MainActivity.this, list);
            mRecy.setAdapter(mAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
