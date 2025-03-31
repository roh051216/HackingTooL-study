import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] subjects = {"국어", "영어", "수학", "과학"};

        int[] scores = new int[4];

        System.out.println("과목의 점수를 입력하세요.");
        for (int i = 0; i < subjects.length; i++) {
            System.out.print(subjects[i] + " 점수: ");
            scores[i] = scanner.nextInt();
        }

        int total = 0;
        for (int score : scores) {
            total += score;
        }

        int integerAverage = total / subjects.length;

        double realAverage = total / (double) subjects.length;

        System.out.println("\n------ 형변환 없는 평균 계산 ------");
        System.out.println("총점: " + total);
        System.out.println("정수 평균: " + integerAverage);
        System.out.println("실수 평균: " + realAverage);

        if (integerAverage == realAverage) {
            System.out.println("정수 평균과 실수 평균은 동일합니다.");
        } else if (integerAverage > realAverage) {
            System.out.println("정수 평균이 실수 평균보다 큽니다.");
        } else {
            System.out.println("실수 평균이 정수 평균보다 큽니다.");
        }

        if (realAverage >= 80) {    
            System.out.println("평균 80점 이상 합격 여부: 합격입니다.");
        } else {
            System.out.println("평균 80점 이상 합격 여부: 불합격입니다.");
        }

        scanner.close();
    }
}