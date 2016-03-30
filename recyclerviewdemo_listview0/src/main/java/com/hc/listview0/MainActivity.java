package com.hc.listview0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> data; //数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<String>();
        for (int i = 1; i < 50; i++) { //初始化数据
            data.add((new Random().nextInt(90) * 10 + 100) + "");
        }
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);//保持固定大小，提高性能
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL); //设置滚动方向
        recyclerView.setLayoutManager(manager); //设置布局管理器  //-------①
        recyclerView.setItemAnimator(new DefaultItemAnimator());//添加动画
        final ViewAdapter adapter = new ViewAdapter(this, data);//创建适配器
        recyclerView.setAdapter(adapter);//设置Adapter
    }
}
