package calculator.domain;

public final class InputExpression {
    private final String body;            // 실제 숫자 부분
    private final String customDelimiter; // 없으면 null

    private InputExpression(String body, String customDelimiter) {
        this.body = body;
        this.customDelimiter = customDelimiter;
    }

    public static InputExpression parse(String raw) {
        if (raw == null) return new InputExpression("", null);

        // 1) \r\n -> \n 정규화
        String normalized = raw.replace("\r\n", "\n");

        // 2) 리터럴 "\n"을 실제 개행으로 치환 (예: "//;\\n1" -> "//;\n1")
        normalized = normalized.replace("\\n", "\n");

        if (normalized.startsWith("//") && normalized.contains("\n")) {
            int nl = normalized.indexOf('\n');
            String delimiter = normalized.substring(2, nl);
            String body = normalized.substring(nl + 1);
            return new InputExpression(body, delimiter);
        }
        return new InputExpression(normalized, null);
    }

    public boolean hasCustom() { return customDelimiter != null; }
    public String body() { return body; }
    public String customDelimiter() { return customDelimiter; }
}
