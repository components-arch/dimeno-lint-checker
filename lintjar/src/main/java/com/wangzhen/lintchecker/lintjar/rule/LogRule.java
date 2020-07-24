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
        return "Log使用不规范";
    }

    @Override
    public String getExplanation() {
        return "请使用封装后的Log工具类，勿直接调用android.util.Log";
    }

    @Override
    public String getFullPath() {
        return "android.util.Log";
    }
}
