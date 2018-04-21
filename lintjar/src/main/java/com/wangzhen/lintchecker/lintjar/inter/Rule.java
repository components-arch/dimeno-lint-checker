package com.wangzhen.lintchecker.lintjar.inter;

/**
 * Issue获取信息接口
 * Created by wangzhen on 2018/4/15.
 */
public interface Rule {
    /**
     * 获取id
     *
     * @return id
     */
    String getId();

    /**
     * 获取简介
     *
     * @return 简介
     */
    String getBriefDescription();

    /**
     * 获取说明
     *
     * @return 说明
     */
    String getExplanation();

    /**
     * 获取全路径
     *
     * @return 全路径
     */
    String getFullPath();
}
