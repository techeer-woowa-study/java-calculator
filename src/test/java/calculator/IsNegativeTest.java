package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class IsNegativeTest {

    @Test
    void 음수가_있으면_예외발생() {
        assertThatThrownBy(() ->
                IsNegative.NonNegative(List.of(1, -2, 3))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 허용되지 않습니다");
    }

    @Test
    void 양수만_있으면_예외없음() {
        IsNegative.NonNegative(List.of(1, 2, 3)); // 예외 안 나야 성공
    }

    @Test
    void 빈리스트는_예외없음() {
        IsNegative.NonNegative(List.of()); // 예외 안 나야 성공
    }
}
