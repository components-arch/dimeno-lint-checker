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
import com.wangzhen.lintchecker.rule.FragmentLayoutNameRule;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.uast.UCallExpression;

import java.util.Collections;
import java.util.List;

/**
 * detect fragment layout name usage.
 * Created by wangzhen on 2020/7/30.
 */
public class FragmentLayoutNameDetector extends Detector implements SourceCodeScanner {
    private static final Rule rule = new FragmentLayoutNameRule();
    public static Issue ISSUE = Issue.create(
            rule.getId(),
            rule.getBriefDescription(),
            rule.getExplanation(),
            Category.MESSAGES,
            5,
            Severity.WARNING,
            new Implementation(FragmentLayoutNameDetector.class, Scope.JAVA_FILE_SCOPE)
    );

    @Nullable
    @Override
    public List<String> applicableSuperClasses() {
        return Collections.singletonList("android.app.Fragment");
    }

    @Nullable
    @Override
    public List<String> getApplicableMethodNames() {
        return Collections.singletonList("inflate");
    }

    @Override
    public void visitMethodCall(@NotNull JavaContext context, @NotNull UCallExpression node, @NotNull PsiMethod method) {
        if (node.getValueArgumentCount() > 0) {
            String layoutRes = node.getValueArguments().get(0).toString().replace("R.layout.", "");
            if (!layoutRes.startsWith("fragment_")) {
                context.report(ISSUE, node, context.getLocation(node), rule.getExplanation());
            }
        }
    }
}
