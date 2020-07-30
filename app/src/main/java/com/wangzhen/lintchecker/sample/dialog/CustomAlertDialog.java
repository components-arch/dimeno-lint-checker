package com.wangzhen.lintchecker.sample.dialog;

import android.content.Context;

import com.wangzhen.lintchecker.sample.R;
import com.wangzhen.lintchecker.sample.base.BaseDialog;

/**
 * CustomAlertDialog
 * Created by wangzhen on 2020/7/24.
 */
public class CustomAlertDialog extends BaseDialog {
    protected CustomAlertDialog(Context context) {
        super(context);
        setContentView(R.layout.dialog_custom_layout);
    }
}
