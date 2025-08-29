package calculator;

import calculator.domain.Calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            // 입력 안내 메시지 출력
            System.out.println("덧셈할 문자열을 입력해 주세요.");

            // 사용자 입력 받기
            String raw = Console.readLine();

            // 계산 실행
            int result = new Calculator().calculate(raw);

            // 결과 출력
            System.out.println("결과 : " + result);
        } finally {
            Console.close();
        }
    }
}
