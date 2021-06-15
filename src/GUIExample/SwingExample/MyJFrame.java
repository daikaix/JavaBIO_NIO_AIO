package GUIExample.SwingExample;

import GUIExample.PaintExample.MyWindow;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame{
    public MyJFrame(){
        setBounds(10,10,200,200);
        setVisible(true);

        JLabel label = new JLabel("asdasda");
        add(label);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = getContentPane();
        container.setBackground(Color.green);

    }
}
