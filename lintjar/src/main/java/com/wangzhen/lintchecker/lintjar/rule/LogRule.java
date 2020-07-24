package com.wangzhen.lintchecker.lintjar.rule;

import com.wangzhen.lintchecker.lintjar.inter.Rule;

/**
 * Log提示信息
 * Created by wangzhen on 2018/4/15.
 */
public class LogRule implements Rule {
    @Override
    public String getId() {
        return LogRule.class.getSimpleName();
    }

    @Override
    public String getBriefDescription() {
        return "避免调用android.util.Log";
    }

    @Override
    public String getExplanation() {
        return "AndroidStudio 4.0+ 请勿直接调用android.util.Log，应该使用封装工具类，防止正式包打印Log.";
    }

    @Override
    public String getFullPath() {
        return "android.util.Log";
    }
}
