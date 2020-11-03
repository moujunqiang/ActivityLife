package com.android.hsm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 男
     */
    private RadioButton mBtnRbMan;
    /**
     * 女
     */
    private RadioButton mBtnRbWoman;
    private RadioGroup mRadiogroup;
    private GridView mGrid;
    /**
     * 提交
     */
    private Button mCommit;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = {R.mipmap.cion, R.mipmap.cion,
            R.mipmap.cion, R.mipmap.cion, R.mipmap.cion, R.mipmap.cion};
    private String[] iconName = {"小龙女", "小龙女", "小龙女", "小龙女", "小龙女", "小龙女"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        initView();

    }

    private void initView() {
        mBtnRbMan = (RadioButton) findViewById(R.id.btn_rb_man);
        mBtnRbWoman = (RadioButton) findViewById(R.id.btn_rb_woman);
        mRadiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        mGrid = (GridView) findViewById(R.id.grid);
        mCommit = (Button) findViewById(R.id.commit);
        mCommit.setOnClickListener(this);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.grid_item, from, to);
        //配置适配器
        mGrid.setAdapter(sim_adapter);
        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(OneActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();

            }
        });
        mGrid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(OneActivity.this, "长按了" + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    public List<Map<String, Object>> getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.commit:
                startActivity(new Intent(OneActivity.this, TwoActivity.class));
                break;
        }
    }
}