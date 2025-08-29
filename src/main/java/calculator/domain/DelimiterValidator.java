package calculator.domain;

public final class DelimiterValidator {
    private DelimiterValidator() {}

    /** body 안에 숫자/마이너스/허용된 구분자만 있는지 검사 */
    public static void validate(String body, char... allowedDelims) {
        for (int i = 0; i < body.length(); i++) {
            char c = body.charAt(i);

            // 숫자 또는 음수 기호는 통과 (음수 예외는 IsNegative가 담당)
            if (isDigit(c) || c == '-') continue;

            // 허용된 구분자인지?
            if (isAllowedDelimiter(c, allowedDelims)) continue;

            // 그 외는 전부 에러
            throw new IllegalArgumentException("허용되지 않은 구분자: '" + printable(c) + "'");
        }
    }

    private static boolean isDigit(char c) { return c >= '0' && c <= '9'; }

    private static boolean isAllowedDelimiter(char c, char[] allowed) {
        for (char d : allowed) if (c == d) return true;
        return false;
    }

    private static String printable(char c) {
        return switch (c) {
            case '\n' -> "\\n";
            case '\r' -> "\\r";
            case '\t' -> "\\t";
            default -> String.valueOf(c);
        };
    }
}
