package com.hc.textinputlayoutdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginFun(View view) {
        hideKeyboard();//隐藏软键盘
        TextInputLayout nameWrapper = (TextInputLayout) findViewById(R.id.nameWrapper);
        TextInputLayout passWrapper = (TextInputLayout) findViewById(R.id.passWrapper);
        passWrapper.setHint("pass:");

        String name = nameWrapper.getEditText().getText().toString();
        String pass = passWrapper.getEditText().getText().toString();

        if (!validate(name))
            nameWrapper.setError("name invalidate");
        else if (!validate(pass))
            passWrapper.setError("pass invalidate");
        else {
            nameWrapper.setErrorEnabled(false);
            passWrapper.setErrorEnabled(false);
            if ("zhangsan".equals(name) && "zhangsan".equals(pass))
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validate(String str) {
        return str.length() > 6 && str.length() < 12;
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager service = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            service.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
