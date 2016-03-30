package com.hc.tablayoutdemo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hcitl on 2016-3-25-0025.
 */
public class MyPagerAdapter extends PagerAdapter {

    private List<View> views;
    private List<String> titles;

    public MyPagerAdapter(List<View> views, List<String> titles) {
        this.views = views;
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;//官方推荐写法
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));//添加页卡
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));//删除页卡
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);//页卡标题
    }
}
