package com.wangzhen.lintchecker.sample;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

/**
 * CustomDialog
 * Created by wangzhen on 2020/7/24.
 */
public class CustomDialog extends Dialog {
    public CustomDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.support_simple_spinner_dropdown_item);
    }
}
