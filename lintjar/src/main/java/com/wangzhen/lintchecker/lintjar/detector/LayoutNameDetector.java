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
import com.intellij.psi.PsiParameter;
import com.wangzhen.lintchecker.lintjar.inter.Rule;
import com.wangzhen.lintchecker.lintjar.rule.LayoutNameRule;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Activity和Fragment布局命名检测
 * Created by wangzhen on 2018/4/22.
 */
public class LayoutNameDetector extends Detector implements Detector.JavaPsiScanner {
    private String methodName = "setContentView";
    private static final Rule rule = new LayoutNameRule();
    public static Issue ISSUE = Issue.create(
            rule.getId(),
            rule.getBriefDescription(),
            rule.getExplanation(),
            Category.MESSAGES,
            5,
            Severity.ERROR,
            new Implementation(LayoutNameDetector.class, Scope.JAVA_FILE_SCOPE)
    );

    @Override
    public List<String> getApplicableMethodNames() {
        return Arrays.asList(methodName);
    }

    @Override
    public void visitMethod(JavaContext context, JavaElementVisitor visitor, PsiMethodCallExpression call, PsiMethod method) {
        String name = method.getName();
        if (methodName.equals(name)) {
            PsiParameter parameter = method.getParameterList().getParameters()[0];
            if (Objects.equals("int", parameter.getType().getPresentableText())) {
                context.report(
                        ISSUE,
                        call,
                        context.getLocation(call),
                        parameter.getText()
                );

//                String s = parameter.toString();
//                String layoutName = s.substring(s.lastIndexOf("."));
//                if(!layoutName.startsWith("activity_")
//                        ||!layoutName.startsWith("fragment_")){
//                    context.report(
//                            ISSUE,
//                            call,
//                            context.getLocation(call),
//                            rule.getExplanation()
//                    );
//                }
            }
        }
    }
}
