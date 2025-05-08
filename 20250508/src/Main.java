import  java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("점수를 입력하세요 : ");
        int score = sc.nextInt();
        String scores;

        switch (score / 10) {
            case 10:
            case 9: scores = "A";
                break;
            case 8: scores = "B";
                break;
            case 7: scores = "C";
                break;
            case 6: scores = "D";
                break;
            default : scores = "F";
        }

        System.out.println("학점 : " + scores);
        sc.close();


    }
}