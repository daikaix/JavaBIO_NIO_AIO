package GUIExample.SwingExample;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {
    public void init(){
        JFrame frame = new JFrame("JFrame");
        frame.setSize(500,500);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.green);

        JLabel label = new JLabel("xiasdasd");
        frame.add(label);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JFrameDemo().init();
    }
}
