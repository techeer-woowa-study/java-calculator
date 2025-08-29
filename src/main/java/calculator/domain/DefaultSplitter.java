package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class DefaultSplitter implements Splitter {
    private static final Pattern pattern = Pattern.compile("[,:]");

    @Override
    public List<String> split(String input) {
        String[] parts = pattern.split(input, -1);
        return Arrays.asList(parts);
    }
}