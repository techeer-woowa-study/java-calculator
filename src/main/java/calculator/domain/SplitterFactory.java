package calculator.domain;

public final class SplitterFactory {
    private SplitterFactory() {}

    public static Splitter from(InputExpression expr) {
        return expr.hasCustom()
                ? new CustomSplitter(expr.customDelimiter())
                : new DefaultSplitter();
    }
}
