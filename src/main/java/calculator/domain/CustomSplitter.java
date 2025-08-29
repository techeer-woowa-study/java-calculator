package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class CustomSplitter implements Splitter {
    private final Pattern pattern;

    public CustomSplitter(String delimiter) {
        // 정규식 특수문자 대응 위해 quote
        this.pattern = Pattern.compile(Pattern.quote(delimiter));
    }

    @Override
    public List<String> split(String input) {
        String[] parts = pattern.split(input, -1);
        return Arrays.asList(parts);
    }
}
