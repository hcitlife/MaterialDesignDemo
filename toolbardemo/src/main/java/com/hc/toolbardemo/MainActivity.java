package com.hc.toolbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);

        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("标题");
        toolbar.setSubtitle("子标题");
        toolbar.setTitleTextColor(0xff000032);
        toolbar.setSubtitleTextColor(0x8fff0f68);

        setSupportActionBar(toolbar);//替换ActionBar为Toolbar

        toolbar.setNavigationIcon(R.drawable.left);

        //        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
        //            @Override
        //            public boolean onMenuItemClick(MenuItem item) {
        //                Toast.makeText(MainActivity.this, "menu item clicked", Toast.LENGTH_SHORT).show();
        //                return false;
        //            }
        //        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "单击 导航按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(MainActivity.this, "单击 菜单按钮", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("扫码");
        menu.add("设置");
        return super.onCreateOptionsMenu(menu);
    }
}
