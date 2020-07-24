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
import com.wangzhen.lintchecker.rule.MessageRule;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.uast.UCallExpression;

import java.util.Collections;
import java.util.List;

/**
 * detect message usage
 * Created by wangzhen on 2018/4/21.
 */
public class MessageDetector extends Detector implements SourceCodeScanner {
    private static final Rule rule = new MessageRule();
    public static Issue ISSUE = Issue.create(
            rule.getId(),
            rule.getBriefDescription(),
            rule.getExplanation(),
            Category.MESSAGES,
            5,
            Severity.WARNING,
            new Implementation(MessageDetector.class, Scope.JAVA_FILE_SCOPE)
    );

    @Override
    public List<String> getApplicableConstructorTypes() {
        return Collections.singletonList(rule.getFullPath());
    }

    @Override
    public void visitConstructor(@NotNull JavaContext context, @NotNull UCallExpression node, @NotNull PsiMethod constructor) {
        context.report(ISSUE, node, context.getLocation(node), rule.getExplanation());
    }
}
