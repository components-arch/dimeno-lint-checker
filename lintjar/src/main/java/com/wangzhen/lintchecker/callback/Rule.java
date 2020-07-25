package com.wangzhen.lintchecker.callback;

/**
 * rule
 * Created by wangzhen on 2018/4/15.
 */
public interface Rule {
    String getId();

    String getBriefDescription();

    String getExplanation();

    String getFullPath();
}
