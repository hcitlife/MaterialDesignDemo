package com.hc.navigationviewdemo1;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setBackgroundResource(R.drawable.background);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Snackbar.make(drawerLayout, item.getTitle() + " pressed", Snackbar.LENGTH_LONG).show();
                item.setCheckable(true);//改变Item的选中状态
                drawerLayout.closeDrawers();//关闭导航菜单
                return true;
            }
        });
    }

    public void fun(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}
