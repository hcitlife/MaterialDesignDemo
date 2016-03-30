package com.hc.tablayoutdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<String> titles = new ArrayList<>();
    private List<View> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        LayoutInflater inflater = LayoutInflater.from(this);

        views.add(inflater.inflate(R.layout.layout1, null));
        views.add(inflater.inflate(R.layout.layout2, null));
        views.add(inflater.inflate(R.layout.layout3, null));

        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        titles.add("推荐");
        titles.add("热点");
        titles.add("订阅");
        for (String title : titles)
            tabLayout.addTab(tabLayout.newTab().setText(title+"fdsfd"));


        MyPagerAdapter adapter = new MyPagerAdapter(views,titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);//和ViewPager联运，必须得在setAdapter之后调用
    }
}

















