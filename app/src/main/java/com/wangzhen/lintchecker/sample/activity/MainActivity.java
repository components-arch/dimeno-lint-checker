package com.wangzhen.lintchecker.sample.activity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import com.wangzhen.lintchecker.sample.R;
import com.wangzhen.lintchecker.sample.base.BaseActivity;
import com.wangzhen.lintchecker.sample.utils.KLog;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._activity_main);

        Log.e("TAG", "This is a test.");

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        Message message = new Message();

        KLog.e("");
    }
}
