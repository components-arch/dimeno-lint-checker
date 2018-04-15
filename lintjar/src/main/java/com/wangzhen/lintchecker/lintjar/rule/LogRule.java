package com.wangzhen.lintchecker.lintjar.rule;

/**
 * Log提示信息
 * Created by wangzhen on 2018/4/15.
 */
public class LogRule implements Rule {
    @Override
    public String getId() {
        return "LogUsage";
    }

    @Override
    public String getBriefDescription() {
        return "避免调用android.util.Log";
    }

    @Override
    public String getExplanation() {
        return "请勿直接调用android.util.Log，应该使用封装工具类";
    }

    @Override
    public String getFullPath() {
        return "android.util.Log";
    }
}
