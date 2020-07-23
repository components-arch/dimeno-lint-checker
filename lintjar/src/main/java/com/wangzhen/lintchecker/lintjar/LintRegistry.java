package com.wangzhen.lintchecker.lintjar;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;
import com.wangzhen.lintchecker.lintjar.detector.LayoutNameDetector;
import com.wangzhen.lintchecker.lintjar.detector.LogDetector;
import com.wangzhen.lintchecker.lintjar.detector.MessageDetector;
import com.wangzhen.lintchecker.lintjar.detector.ThreadUsageDetector;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * 注册自定义Lint规则
 */
public class LintRegistry extends IssueRegistry {
    @NotNull
    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(
                LogDetector.ISSUE,
                ThreadUsageDetector.ISSUE,
                MessageDetector.ISSUE,
                LayoutNameDetector.ISSUE
        );
    }
}
