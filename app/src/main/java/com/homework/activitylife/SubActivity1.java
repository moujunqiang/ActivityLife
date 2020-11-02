package com.homework.activitylife;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity1 extends AppCompatActivity {

    /**
     * 123
     */
    private TextView mText1;
    /**
     * 123
     */
    private TextView mText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        initView();
    }

    private void initView() {
        mText1 = (TextView) findViewById(R.id.text1);
        mText2 = (TextView) findViewById(R.id.text2);
        mText1.setText("用户名是："+getIntent().getStringExtra("name"));
        mText2.setText("密码是 ："+getIntent().getStringExtra("pwd"));

    }
}