package com.wangzhen.lintchecker.sample;

import android.os.Bundle;
import android.os.Message;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

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
