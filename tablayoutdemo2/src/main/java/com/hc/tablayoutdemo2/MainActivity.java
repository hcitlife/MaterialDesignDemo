package com.hc.tablayoutdemo2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("热点");
        titles.add("订阅");

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecommendFragment());
        fragments.add(new HotNewsFragment());
        fragments.add(new SubscribeFragment());

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来
//        tabLayout.setTabsFromPagerAdapter(adapter);//给TabLayout设置适配器
    }
}
