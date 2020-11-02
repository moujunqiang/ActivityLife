package com.homework.activitylife;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 简单的正常页面
     */
    private Button btn1;
    /**
     * 对话框式页面
     */
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("life", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("life", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("life", "onDestroy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("life", "onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("life", "onResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("life", "onRestart");

    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this, AlertActivity.class));

                break;
            case R.id.btn3:
                startActivity(new Intent(MainActivity.this, MainActivity3.class));

                break;
        }
    }
}