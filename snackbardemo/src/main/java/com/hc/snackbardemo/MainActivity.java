package com.hc.snackbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.root_layout);
    }

    public void fun1(View view) {
        Snackbar.make(relativeLayout, "SnackBar", Snackbar.LENGTH_LONG)
                .show();
    }

    public void fun2(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }
}
