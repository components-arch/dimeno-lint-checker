package com.wangzhen.lintchecker.rule;

import com.wangzhen.lintchecker.callback.Rule;

/**
 * 布局命名提示信息
 * Created by wangzhen on 2018/4/22.
 */
public class LayoutNameRule implements Rule {
    @Override
    public String getId() {
        return LayoutNameRule.class.getSimpleName();
    }

    @Override
    public String getBriefDescription() {
        return "Activity和Fragment布局命名规范";
    }

    @Override
    public String getExplanation() {
        return "Activity布局命名要以'activity_'开头，Fragment布局命名要以'fragment_'开头";
    }

    @Override
    public String getFullPath() {
        return null;
    }
}
