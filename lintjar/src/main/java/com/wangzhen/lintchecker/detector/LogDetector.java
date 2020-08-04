package com.wangzhen.lintchecker.detector;

import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.android.tools.lint.detector.api.SourceCodeScanner;
import com.intellij.psi.PsiMethod;
import com.wangzhen.lintchecker.callback.Rule;
import com.wangzhen.lintchecker.rule.LogRule;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.uast.UCallExpression;

import java.util.Arrays;
import java.util.List;

/**
 * detect log usage
 * Created by wangzhen on 2018/4/15.
 */
public class LogDetector extends Detector implements SourceCodeScanner {
    private static final Rule rule = new LogRule();
    public static final Issue ISSUE = Issue.create(
            rule.getId(),
            rule.getBriefDescription(),
            rule.getExplanation(),
            Category.MESSAGES,
            5,
            Severity.WARNING,
            new Implementation(LogDetector.class, Scope.JAVA_FILE_SCOPE)
    );

    @Nullable
    @Override
    public List<String> getApplicableMethodNames() {
        return Arrays.asList("v", "d", "i", "w", "e");
    }

    @Override
    public void visitMethodCall(@NotNull JavaContext context, @NotNull UCallExpression node, @NotNull PsiMethod method) {
        boolean isMemberInClass = context.getEvaluator().isMemberInClass(method, "android.util.Log");
        boolean isMemberInSubClassOf = context.getEvaluator().isMemberInSubClassOf(method, "android.util.Log", true);
        if (isMemberInClass || isMemberInSubClassOf) {
            context.report(ISSUE, node, context.getLocation(node), rule.getExplanation());
        }
    }
}
