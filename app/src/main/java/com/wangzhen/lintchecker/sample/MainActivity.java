package com.wangzhen.lintchecker.sample;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("TAG", "This is a test.");

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        Message message = new Message();
    }
}
