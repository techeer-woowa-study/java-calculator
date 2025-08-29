package calculator.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int calculate(String raw) {
        if (raw == null || raw.isBlank()) return 0;

        // 1) 입력 파싱
        InputExpression expr = InputExpression.parse(raw);

        // 2) 유효성 검사 (허용 구분자 지정)
        if (expr.hasCustom()) {
            String d = expr.customDelimiter();
            if (d == null || d.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
            }
            // 커스텀 구분자는 문자 집합이 아니라 '문자열'이므로, 구성 문자들이 body에 등장하는 것을 허용하도록
            // 각 문자들을 허용 목록에 추가
            char[] allowed = d.toCharArray();
            DelimiterValidator.validate(expr.body(), allowed);
        } else {
            DelimiterValidator.validate(expr.body(), ',', ':');
        }

        // 3) Splitter 생성 및 분리
        Splitter splitter = SplitterFactory.from(expr);
        List<String> parts = splitter.split(expr.body());

        // 4) 문자열 -> 정수 (공백/빈문자열 -> 0)
        List<Integer> numbers = parts.stream()
                .map(s -> {
                    String t = s.trim();
                    return t.isEmpty() ? 0 : Integer.parseInt(t);
                })
                .collect(Collectors.toList());

        // 5) 음수 금지
        IsNegative.NonNegative(numbers);

        // 6) 합산
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
