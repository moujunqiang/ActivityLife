package com.homework.activitylife;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity implements View.OnClickListener {

    private ListView mListItem;
    /**
     * 确定
     */
    private Button mBtn3;
    private String data[] = {"Item1", "Item2", "Item3"};//假数据
    private String selectItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        initView();
    }

    private void initView() {
        mListItem = (ListView) findViewById(R.id.list_item);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn3.setOnClickListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);//新建并配置ArrayAapeter
        mListItem.setAdapter(adapter);
        mListItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem = data[position];
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn3:
                if (!TextUtils.isEmpty(selectItem)){
                    Intent data = new Intent();
                    data.putExtra("item",selectItem);
                    setResult(100, data);
                }
                finish();
                break;
        }
    }
}