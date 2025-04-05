import java.util.Scanner;

public class ScoreProcessor {
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

        int integerN = total / subjects.length;

        double realN = total / (double) subjects.length;

        System.out.println("\n------ 형변환 없는 평균 계산 ------");
        System.out.println("총점: " + total);
        System.out.println("정수 평균: " + integerN);

        System.out.println(("\n-----형변환 있는 평균 계산--------"));
        System.out.println("실수 평균: " + realN);
        System.out.printf("소수점 둘째자리 : %.2f\n", realN); //Gpt 사용 후 알아냄. System.out.printf 는 formatted print 를 지원


        System.out.println("\n--------자료형 논리 비교----------");
        if (integerN == realN) {
            System.out.println("정수 평균과 실수 평균은 동일합니다.");
        } else if (integerN > realN) {
            System.out.println("정수 평균이 실수 평균보다 큽니다.");
        } else {
            System.out.println("실수 평균이 정수 평균보다 큽니다.");
        }


        if (realN >= 80) {
            System.out.println("평균 80점 이상 합격 여부: 합격입니다.");
        } else {
            System.out.println("평균 80점 이상 합격 여부: 불합격입니다.");
        }

        scanner.close();
    }
}

