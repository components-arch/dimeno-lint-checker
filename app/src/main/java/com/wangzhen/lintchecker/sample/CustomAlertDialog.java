package com.wangzhen.lintchecker.sample;

import android.app.AlertDialog;
import android.content.Context;

/**
 * CustomAlertDialog
 * Created by wangzhen on 2020/7/24.
 */
public class CustomAlertDialog extends AlertDialog {
    protected CustomAlertDialog(Context context) {
        super(context);
        setContentView(R.layout.dialog_custom_layout);
    }
}
