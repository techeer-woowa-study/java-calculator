package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultSplitterTest {

    private final Splitter splitter = new DefaultSplitter();

    @Test
    void 콤마로_분리된다() {
        List<String> result = splitter.split("1,2,3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 콜론으로_분리된다() {
        List<String> result = splitter.split("1:2:3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 콤마와_콜론_섞어서도_분리된다() {
        List<String> result = splitter.split("1,2:3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 연속된_구분자는_빈문자열을_만든다() {
        List<String> result = splitter.split("1,,2");
        assertThat(result).containsExactly("1", "", "2");
    }
}
