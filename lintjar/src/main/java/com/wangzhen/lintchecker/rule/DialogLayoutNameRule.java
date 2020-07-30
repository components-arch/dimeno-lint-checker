package com.wangzhen.lintchecker.rule;

import com.wangzhen.lintchecker.callback.Rule;

/**
 * DialogLayoutNameRule
 * Created by wangzhen on 2020/7/30.
 */
public class DialogLayoutNameRule implements Rule {
    @Override
    public String getId() {
        return DialogLayoutNameRule.class.getName();
    }

    @Override
    public String getBriefDescription() {
        return "Dialog命名规范";
    }

    @Override
    public String getExplanation() {
        return "Dialog布局建议以\"dialog_\"开头";
    }
}
