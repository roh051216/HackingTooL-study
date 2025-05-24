import java.util.Scanner;

public class SeatReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("좌석의 행 수를 입력하세요: ");
        int row = scanner.nextInt();
        System.out.print("좌석의 열 수를 입력하세요: ");
        int col = scanner.nextInt();

        int[][] seats = new int[row][col];

        while (true) {
            System.out.print("예약할 좌석의 행과 열 번호를 입력하세요 (종료: 0 0): ");
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            if (r == 0 && c == 0) {
                break;
            }

            if (r < 1 || r > row || c < 1 || c > col) {
                System.out.println("잘못된 좌석 번호입니다. 다시 입력하세요.");
                continue;
            }

            if (seats[r - 1][c - 1] == 0) {
                seats[r - 1][c - 1] = 1;
                System.out.println("좌석이 예약되었습니다.");
            } else {
                System.out.println("이미 예약된 좌석입니다.");
            }
        }

        System.out.println("\n현재 좌석 상태:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
