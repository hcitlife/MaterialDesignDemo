package com.hc.collapsingtoolbarlayout;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置工具栏
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//替换ActionBar为Toolbar
//        toolbar.setNavigationIcon(R.drawable.controlbar_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置标题栏
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle("可折叠工具栏");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("扫码");
        menu.add("设置");
        return super.onCreateOptionsMenu(menu);
    }
}
