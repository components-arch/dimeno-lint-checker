package com.wangzhen.lintchecker.rule;

import com.wangzhen.lintchecker.callback.Rule;

/**
 * fragment layout name rule
 * Created by wangzhen on 2020/7/30.
 */
public class FragmentLayoutNameRule implements Rule {
    @Override
    public String getId() {
        return FragmentLayoutNameRule.class.getName();
    }

    @Override
    public String getBriefDescription() {
        return "Fragment布局命名不规范";
    }

    @Override
    public String getExplanation() {
        return "Fragment布局建议以\"fragment_\"开头";
    }
}
