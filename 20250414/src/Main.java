import  java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("점수를 입력하세요 : ");
        int score = sc.nextInt();
        String scores;

        if (score >= 90) {
            scores = ("A");
        }else if (score >= 80) {
            scores = ("B");
        }else if (score >= 70) {
            scores = ("C");
        }else if (score >= 60) {
            scores = ("D");
        }else {
            scores = ("F");
        }

        System.out.println("학점 : " + scores);
        sc.close();


    }
}