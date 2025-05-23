import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // SwingUtilities.invokeLater를 사용하여 GUI를 이벤트 디스패치 스레드에서 실행
        SwingUtilities.invokeLater(() -> {
            // HackingToolFrame의 인스턴스를 생성하고 화면에 표시
            new HackingToolFrame().setVisible(true);
        });
    }
}