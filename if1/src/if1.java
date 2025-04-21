import java.util.Scanner;

public class if1 {
    public static void main(String[] args) {
        System.out.println("정수를 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        int intN = sc.nextInt();

        if (intN >= 0 && intN <= 100) {
            System.out.println("1에서 100사이의 값입니다.");
        }
        else{
            System.out.println("1에서 100사이의 값이 아닙니다.");
        }
        }
    }
