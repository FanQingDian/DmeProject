package com.dian.flowlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private XCFlowLayout mFlowlayout;
    private String mNames[] = {
            "welcome", "android", "TextView", "apple", "jamy", "bryant",
            "jordan", "layout", "viewgroup", "margin", "padding", "text",
            "name", "type", "search", "logcat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlowlayout = (XCFlowLayout) findViewById(R.id.flowlayout);
        initChildViews();
    }

    private void initChildViews() {
        MarginLayoutParams lp = new MarginLayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        for (int i = 0; i < mNames.length; i++) {
            TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setBackgroundResource(R.drawable.text_bg);
            view.setTextColor(Color.WHITE);
            mFlowlayout.addView(view, lp);
            final int position = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "点到" + mNames[position] + "了", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
