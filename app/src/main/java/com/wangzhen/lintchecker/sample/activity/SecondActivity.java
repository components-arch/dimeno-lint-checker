package com.wangzhen.lintchecker.sample.activity;

import android.app.Activity;
import android.os.Bundle;

import com.wangzhen.lintchecker.sample.R;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._activity_main);
    }
}