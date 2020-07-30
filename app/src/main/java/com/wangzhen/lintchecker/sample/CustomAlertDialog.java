package com.wangzhen.lintchecker.sample;

import android.content.Context;

/**
 * CustomAlertDialog
 * Created by wangzhen on 2020/7/24.
 */
public class CustomAlertDialog extends BaseDialog {
    protected CustomAlertDialog(Context context) {
        super(context);
        setContentView(R.layout.support_simple_spinner_dropdown_item);
    }
}
