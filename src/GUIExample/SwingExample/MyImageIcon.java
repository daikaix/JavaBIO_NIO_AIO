package GUIExample.SwingExample;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyImageIcon extends JFrame {
    public MyImageIcon(){

        JLabel label = new JLabel("ImageIcon");

        URL url = MyImageIcon.class.getResource("0.jpg");
        ImageIcon imageIcon = new ImageIcon(url);

        label.setIcon(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(label);

        setBounds(10,10,200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyImageIcon();
    }
}
