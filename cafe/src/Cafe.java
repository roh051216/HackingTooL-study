import java.util.Scanner;

public class Cafe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] menu = {"아메리카노", "카페라떼", "카푸치노"};
        int[] prices = {3000, 4000, 4500};

        String[] size = {"Small", "Medium", "Large"};
        int[] add_prices = {500, 1000};

        String[] ob = {"샷 추가", "시럽 추가", "샷과 시럽 모두 추가"};
        int[] add_ob = {500, 300, 800};

        System.out.println("=== 카페 음료 가격 계산기 ===");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i] + " - " + prices[i] + "원");
        }
        System.out.println("--- 사이즈 선택 ---");
        for (int i = 0; i < size.length; i++) {
            if (i == 0)
                System.out.println((i + 1) + ". " + size[i] + " - 추가 금액 없음");
            else
                System.out.println((i + 1) + ". " + size[i] + " - " + add_prices[i - 1] + "원");
        }
        System.out.println("--- 옵션 선택 ---");
        for (int i = 0; i < ob.length; i++) {
            System.out.println((i + 1) + ". " + ob[i] + " - " + add_ob[i] + "원");
        }

        System.out.print("음료 번호를 선택하세요: ");
        int choice = scanner.nextInt();
        System.out.println("음료 사이즈를 선택하세요: ");
        int size_choice = scanner.nextInt();
        System.out.println("옵션을 선택하세요: ");
        int ob_choice = scanner.nextInt();

        if (choice < 1 || choice > menu.length) {
            System.out.println("잘못된 선택입니다.");
            return;
        }
        if (size_choice < 1 || size_choice > size.length) {
            System.out.println("사이즈를 잘못 선택하셨습니다.");
            return;
        }
        if (ob_choice < 1 || ob_choice > ob.length) {
            System.out.println("옵션을 잘못 선택하셨습니다.");
            return;
        }

        System.out.print("수량을 입력하세요: ");
        int quantity = scanner.nextInt();

        int basePrice = prices[choice - 1];
        int sizePrice = (size_choice == 1) ? 0 : add_prices[size_choice - 2];
        int optionPrice = add_ob[ob_choice - 1];

        int total = (basePrice + sizePrice + optionPrice) * quantity;
        System.out.println("총 가격: " + total + "원");
    }
}
