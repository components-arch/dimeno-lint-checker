package com.wangzhen.lintchecker;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;
import com.wangzhen.lintchecker.detector.ActivityLayoutNameDetector;
import com.wangzhen.lintchecker.detector.DialogLayoutNameDetector;
import com.wangzhen.lintchecker.detector.FragmentLayoutNameDetector;
import com.wangzhen.lintchecker.detector.LogDetector;
import com.wangzhen.lintchecker.detector.MessageDetector;
import com.wangzhen.lintchecker.detector.ThreadDetector;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * lint rules registry
 * Created by wangzhen on 2020/7/30.
 */
public class LintRegistry extends IssueRegistry {
    @NotNull
    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(
                LogDetector.ISSUE,
                ThreadDetector.ISSUE,
                MessageDetector.ISSUE,
                ActivityLayoutNameDetector.ISSUE,
                FragmentLayoutNameDetector.ISSUE,
                DialogLayoutNameDetector.ISSUE
        );
    }
}
