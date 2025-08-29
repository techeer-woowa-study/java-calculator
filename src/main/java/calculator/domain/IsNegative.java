package calculator.domain;
import java.util.List;

public class IsNegative {
    private IsNegative() {}

    public static void NonNegative(List<Integer> ints) {
        ints.stream().filter(n -> n < 0).findFirst()
                .ifPresent(n -> { throw new IllegalArgumentException("음수는 허용되지 않습니다: " + n); });
    }
}
