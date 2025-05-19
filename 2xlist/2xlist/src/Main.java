import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("학생 수를 입력하세요 : ");
        int a = sc.nextInt();
        System.out.println("과목 수를 입력하세요 : ");
        int b = sc.nextInt();


        int[][] scores = new int[a][b];


        for (int i = 0; i < a; i++) {
            System.out.println("\n[" + (i + 1) + "번 학생의 성적 입력]");
            for (int j = 0; j < b; j++) {
                System.out.println("과목 " + (j + 1) + " 점수: ");
                scores[i][j] = sc.nextInt();
            }
        }

        System.out.println("\n----성적표----");
        for (int i = 0; i < a; i++) {
            System.out.println("\n" + (i + 1) + "번 학생 : " + scores[i][0]);
            for (int j = 1; j < b; j++) {
                System.out.println(scores[i][j]);
            }


        }
    }

}