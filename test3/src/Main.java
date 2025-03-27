public class Main{
    public static void main(String[] args) {
        // 주어진 값들
        double doubleValue = 2.71828;

        // double에서 다른 타입으로의 형변환 결과 출력
        System.out.println("\n=== double 형변환 ===");
        System.out.println("1. double -> byte: " + (byte)doubleValue);
        System.out.println("2. double -> short: " + (short)doubleValue);
        System.out.println("3. double -> int: " + (int)doubleValue);
        System.out.println("4. double -> long: " + (long)doubleValue);
        System.out.println("5. double -> float: " + (float)doubleValue);
        System.out.println(("이유 : float 은 실수타입이기에 소수점이 보임 나머지는 정수타입이기에 소수점이 출력되지가 않음"));
    }
}

//아래 소스 코드를 통해 형변환을 실행한 후 정답 이미지와 그 이유를 각각 작성하시오.

//이유 : float 은 실수타입이기에 소수점이 보임 나머지는 정수타입이기에 소수점이 출력되지가 않음