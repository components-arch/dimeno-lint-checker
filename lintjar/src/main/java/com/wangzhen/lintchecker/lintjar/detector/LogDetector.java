package com.wangzhen.lintchecker.lintjar.detector;

import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiMethodCallExpression;
import com.wangzhen.lintchecker.lintjar.inter.Rule;
import com.wangzhen.lintchecker.lintjar.rule.LogRule;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * Log检测
 * Created by wangzhen on 2018/4/15.
 */
public class LogDetector extends Detector implements Detector.UastScanner {
    private static final Rule rule = new LogRule();
    public static final Issue ISSUE = Issue.create(
            rule.getId(),
            rule.getBriefDescription(),
            rule.getExplanation(),
            Category.MESSAGES,
            5,
            Severity.ERROR,
            new Implementation(LogDetector.class, Scope.JAVA_FILE_SCOPE)
    );

    @Nullable
    @Override
    public List<String> getApplicableMethodNames() {
        return Arrays.asList("v", "d", "i", "w", "e");
    }

    @Override
    public void visitMethod(JavaContext context, JavaElementVisitor
            visitor, PsiMethodCallExpression call, PsiMethod method) {
        if (context.getEvaluator().isMemberInClass(method, rule.getFullPath())) {
            context.report(ISSUE, call, context.getLocation(call.getMethodExpression()), rule.getExplanation());
        }
    }
}
