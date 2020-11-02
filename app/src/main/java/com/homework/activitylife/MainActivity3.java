package com.homework.activitylife;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    /**
     * 输入文本
     */
    private EditText mEtNum;
    /**
     * 拨打电话
     */
    private Button mBtnCall;
    /**
     * 输入文本
     */
    private EditText mEtName;
    /**
     * 输入文本
     */
    private EditText mEtPwd;
    /**
     * 登录1
     */
    private Button mLogin1;
    /**
     * 登录2
     */
    private Button mLogin2;
    private TextView mTvSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        mEtNum = (EditText) findViewById(R.id.et_num);
        mBtnCall = (Button) findViewById(R.id.btn_call);
        mBtnCall.setOnClickListener(this);
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        mLogin1 = (Button) findViewById(R.id.login1);
        mLogin1.setOnClickListener(this);
        mLogin2 = (Button) findViewById(R.id.login2);
        mLogin2.setOnClickListener(this);
        mTvSelect = (TextView) findViewById(R.id.tv_select);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_call:
                if (!TextUtils.isEmpty(mEtNum.getText().toString())) {
                    callCardNumber();
                }
                break;
            case R.id.login1:
                Intent intent = new Intent(MainActivity3.this, SubActivity1.class);
                intent.putExtra("name", mEtName.getText().toString());
                intent.putExtra("pwd", mEtPwd.getText().toString());
                startActivity(intent);
                break;
            case R.id.login2:
                Intent intent1 = new Intent(MainActivity3.this, SubActivity2.class);
                startActivityForResult(intent1, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mTvSelect.setText("你选中的Item是：" + data.getStringExtra("item"));
    }

    public void callCardNumber() {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + mEtNum.getText().toString()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(intent);
    }
}