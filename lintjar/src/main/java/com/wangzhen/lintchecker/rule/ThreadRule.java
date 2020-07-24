package com.wangzhen.lintchecker.rule;

import com.wangzhen.lintchecker.callback.Rule;

/**
 * Thread提示信息
 * Created by wangzhen on 2018/4/15.
 */

public class ThreadRule implements Rule {
    @Override
    public String getId() {
        return ThreadRule.class.getSimpleName();
    }

    @Override
    public String getBriefDescription() {
        return "避免自己创建Thread";
    }

    @Override
    public String getExplanation() {
        return "建议使用AsyncTask或统一的线程管理工具类";
    }

    @Override
    public String getFullPath() {
        return "java.lang.Thread";
    }
}
