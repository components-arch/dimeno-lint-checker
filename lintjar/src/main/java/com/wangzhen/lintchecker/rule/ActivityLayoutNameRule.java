package com.wangzhen.lintchecker.rule;

import com.wangzhen.lintchecker.callback.Rule;

/**
 * activity name rule
 * Created by wangzhen on 2018/4/22.
 */
public class ActivityLayoutNameRule implements Rule {
    @Override
    public String getId() {
        return ActivityLayoutNameRule.class.getSimpleName();
    }

    @Override
    public String getBriefDescription() {
        return "Activity布局命名规范";
    }

    @Override
    public String getExplanation() {
        return "Activity布局建议以\"activity_\"开头";
    }
}
