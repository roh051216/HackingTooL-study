import java.util.Scanner;

public class SumHolNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력하시오 : ");
        int n = sc.nextInt();
        int sum = 0;


        for (int i = 1; i <= n; i += 2) {
            if (i % 2 == 1) {
                sum += i;
            }

            }

        System.out.println("홀수의 합 : " + sum);
    }
}