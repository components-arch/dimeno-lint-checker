package com.wangzhen.lintchecker.lintjar.rule;

import com.wangzhen.lintchecker.lintjar.inter.Rule;

/**
 * Message提示信息
 * Created by wangzhen on 2018/4/21.
 */
public class MessageRule implements Rule {
    @Override
    public String getId() {
        return MessageRule.class.getSimpleName();
    }

    @Override
    public String getBriefDescription() {
        return "避免直接创建Message";
    }

    @Override
    public String getExplanation() {
        return "请勿直接new Message()，尽量使用Message.obtain()";
    }

    @Override
    public String getFullPath() {
        return "android.os.Message";
    }
}
