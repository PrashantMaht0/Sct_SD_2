import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){
        this.setTitle("My frame");
        this.setSize(750, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Codes\\JABA\\swing_test\\logo.png"); 
        this.setIconImage(icon);
        this.setVisible(true);
    }
}