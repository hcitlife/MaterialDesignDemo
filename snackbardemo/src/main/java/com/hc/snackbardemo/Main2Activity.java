package com.hc.snackbardemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.container);
    }

    public void fun1(View view) {
        Snackbar.make(coordinatorLayout, "SnackBar", Snackbar.LENGTH_SHORT)
                .setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(coordinatorLayout, "SnackBar", Snackbar.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    public static void setSnackbarColor(Snackbar snackbar, int textColor, int actionColor) {
        View view = snackbar.getView();
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(textColor);
        ((Button) view.findViewById(R.id.snackbar_action)).setTextColor(actionColor);
    }

    public void fun2(View view) {
        Snackbar snackBar = Snackbar.make(coordinatorLayout, "SnackBar", Snackbar.LENGTH_INDEFINITE);
        snackBar.setAction("Click", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setSnackbarColor(snackBar, Color.BLUE, Color.RED);
        snackBar.show();
    }
}
