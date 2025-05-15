import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("1부터 100 사이의 숫자를 입력하시오: ");
            n = sc.nextInt();
            if (n >= 1 && n <= 100) {
                break;
            }

            System.out.println("잘못된 입력입니다. 다시 입력하시오.");
        }

        System.out.println("입력 완료! 프로그램을 종료합니다.");
    }
}
