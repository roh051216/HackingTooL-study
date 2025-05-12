public class SumEvenNumbers {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 1000; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        
        System.out.println("1부터 1000까지 짝수의 합: " + sum);
    }
}