# dimeno-lint-checker
> Android自定义编码规范校验

[![Platform](https://img.shields.io/badge/Platform-Android-00CC00.svg?style=flat)](https://www.android.com)
[![](https://jitpack.io/v/dimeno-tech/dimeno-lint-checker.svg)](https://jitpack.io/#dimeno-tech/dimeno-lint-checker)

### 依赖导入

项目根目录

``` gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

模块目录

``` gradle
dependencies {
	implementation 'com.github.lavalike:dimeno-lint-checker:0.0.1'
}
```

### 代码示例

日志检测

``` java
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
```

注册

``` java
public class LintRegistry extends IssueRegistry {
    @NotNull
    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(
                LogDetector.ISSUE
        );
    }
}
```