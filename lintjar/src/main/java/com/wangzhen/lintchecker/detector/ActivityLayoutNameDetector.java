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
import com.wangzhen.lintchecker.rule.LayoutNameRule;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.uast.UCallExpression;
import org.jetbrains.uast.UExpression;

import java.util.Collections;
import java.util.List;

/**
 * detect activity layout name usage.
 * Created by wangzhen on 2018/4/22.
 */
public class ActivityLayoutNameDetector extends Detector implements SourceCodeScanner {
    private static final Rule rule = new LayoutNameRule();
    public static Issue ISSUE = Issue.create(
            rule.getId(),
            rule.getBriefDescription(),
            rule.getExplanation(),
            Category.MESSAGES,
            5,
            Severity.WARNING,
            new Implementation(ActivityLayoutNameDetector.class, Scope.JAVA_FILE_SCOPE)
    );

    @Override
    public List<String> getApplicableMethodNames() {
        return Collections.singletonList("setContentView");
    }

    @Override
    public void visitMethodCall(@NotNull JavaContext context, @NotNull UCallExpression node, @NotNull PsiMethod method) {
        boolean memberInActivity = context.getEvaluator().isMemberInClass(method, "androidx.appcompat.app.AppCompatActivity");
        if (memberInActivity) {
            for (UExpression argument : node.getValueArguments()) {
                if (argument.getExpressionType() != null) {
                    String type = argument.getExpressionType().getCanonicalText();
                    if ("int".equals(type)) {
                        String layoutRes = argument.toString().replace("R.layout.", "");
                        if (!layoutRes.startsWith("activity_")) {
                            context.report(ISSUE, node, context.getLocation(node), "建议Activity布局以\"activity_\"开头");
                        }
                    }
                }
            }
        }
    }
}
