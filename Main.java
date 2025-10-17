import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Smart Attendance System");
        JButton registerBtn = new JButton("Register Student");
        JButton recognizeBtn = new JButton("Mark Attendance");

        registerBtn.setBounds(50, 50, 200, 50);
        recognizeBtn.setBounds(50, 150, 200, 50);

        frame.add(registerBtn);
        frame.add(recognizeBtn);

        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Register.main(null);
            }
        });

        recognizeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Recognize.main(null);
            }
        });

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
