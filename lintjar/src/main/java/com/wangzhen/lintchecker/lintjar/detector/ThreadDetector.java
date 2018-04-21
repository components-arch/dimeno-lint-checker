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
import com.intellij.psi.PsiNewExpression;
import com.wangzhen.lintchecker.lintjar.inter.Rule;
import com.wangzhen.lintchecker.lintjar.rule.ThreadRule;

import java.util.Collections;
import java.util.List;

/**
 * 线程检测
 * Created by wangzhen on 2018/4/15.
 */
public class ThreadDetector extends Detector implements Detector.JavaPsiScanner {
    private static final Rule rule = new ThreadRule();
    public static final Issue ISSUE = Issue.create(
            rule.getId(),
            rule.getBriefDescription(),
            rule.getExplanation(),
            Category.PERFORMANCE,
            5,
            Severity.ERROR,
            new Implementation(ThreadDetector.class, Scope.JAVA_FILE_SCOPE)
    );

    @Override
    public List<String> getApplicableConstructorTypes() {
        return Collections.singletonList(rule.getFullPath());
    }

    @Override
    public void visitConstructor(JavaContext context, JavaElementVisitor visitor, PsiNewExpression node, PsiMethod constructor) {
        context.report(
                ISSUE,
                node,
                context.getLocation(node),
                rule.getExplanation()
        );
    }
}