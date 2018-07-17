package ru.panizaandrey.dz4;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.KeyAdapter;
        import java.awt.event.KeyEvent;
        import java.io.IOException;

public class Chat extends JFrame{
    JPanel jpN = new JPanel(new GridLayout());
    JPanel jpS = new JPanel(new GridLayout());
    JButton jb = new JButton("Ввод");
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jta);
    JTextField jtf = new JTextField();

    Chat() throws IOException {
        super("Окно чата");
        setSize(300, 400);
        setMinimumSize(new Dimension(300, 400));
        jb.addActionListener(e -> {
            sendMessage();
        });
        jtf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
            }
        });
        jpN.add(jsp);
        jpS.add(jtf);
        jpS.add(jb);
        add(jpN);
        add("South", jpS);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void sendMessage() {
        String out = jtf.getText();
        jta.append(out + " \n");
        jtf.setText("");
    }
}
