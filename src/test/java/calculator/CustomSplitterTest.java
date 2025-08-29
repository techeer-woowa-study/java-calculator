package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CustomSplitterTest {

    @Test
    void 세미콜론으로_분리된다() {
        Splitter splitter = new CustomSplitter(";");
        List<String> result = splitter.split("1;2;3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 특수문자도_구분자로_사용할수있다() {
        Splitter splitter = new CustomSplitter(".");
        List<String> result = splitter.split("1.2.3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 파이프문자도_구분자로_사용할수있다() {
        Splitter splitter = new CustomSplitter("|");
        List<String> result = splitter.split("1|2|3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 연속된_커스텀구분자는_빈문자열을_만든다() {
        Splitter splitter = new CustomSplitter(";");
        List<String> result = splitter.split("1;;2");
        assertThat(result).containsExactly("1", "", "2");
    }
}
