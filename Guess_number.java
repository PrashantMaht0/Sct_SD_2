import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Guess_number {
    Random rand = new Random();
    private int random_int = rand.nextInt(10);
    private JTextField myTextField;
    private JButton hint;
    private JButton submit;
    private Font font = new Font("Verdana", Font.BOLD, 20);

    Guess_number() {
        MyFrame frame = new MyFrame();
        frame.setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 750, 375);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 375, 750, 375);

        JLabel label1 = new JLabel("Guess The Number");
        label1.setBounds(165, 120, 450, 60);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setFont(new Font("Verdana", Font.BOLD, 40));

        hint = new JButton("Hint");
        hint.setBounds(550, 10, 120, 40);
        hint.setFocusable(false);
        hint.setHorizontalAlignment(JButton.RIGHT);
        hint.setFont(font);
        try {
            Image image = ImageIO.read(new File("D:\\Codes\\JABA\\swing_test\\bulb.png"));
            Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(newimg);
            hint.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        myTextField = new JTextField(10);
        myTextField.setBounds(155, 10, 300, 50);
        myTextField.setFont(font);
        submit = new JButton("Submit");
        submit.setBounds(460, 10, 150, 50);
        submit.setFocusable(false);
        submit.setFont(new Font("Verdana", Font.BOLD, 20));

        panel2.add(submit);
        panel2.add(myTextField);
        panel1.add(label1);
        panel1.add(hint);

        frame.add(panel1);
        frame.add(panel2);

        hint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Its a number Between 1 to 10", "Invalid Input",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(myTextField.getText());
                if (num == random_int) {
                    JOptionPane.showMessageDialog(null, "You Guess the correct number", "Invalid Input",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong number!", "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Guess_number();
    }
}
